package com.proavos.training.onlinetkt.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.proavos.training.onlinetkt.common.ApplicationException;
import com.proavos.training.onlinetkt.common.BaseJPADAOImpl;
import com.proavos.training.onlinetkt.common.Constants;
import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
import com.proavos.training.onlinetkt.dto.BookBusRequestDTO;
import com.proavos.training.onlinetkt.dto.BookBusResponseDTO;
import com.proavos.training.onlinetkt.dto.BusDTO;
import com.proavos.training.onlinetkt.dto.SearchBusRequestDTO;
import com.proavos.training.onlinetkt.dto.SearchBusResponseDTO;
import com.proavos.training.onlinetkt.model.Booking;
import com.proavos.training.onlinetkt.model.City;
import com.proavos.training.onlinetkt.model.Inventory;

@ApplicationScoped
public class SearchAndBookDAOImpl extends BaseJPADAOImpl implements SearchAndBookDAO {

	@Override
	public List<City> getAllActiveCities() {
		List<City> cities = Collections.emptyList();

		//JPQL
		String jpaQuery = "SELECT a FROM City a WHERE a.status = :status";
		TypedQuery<City> query = this.em.createQuery(jpaQuery, City.class);
		query.setParameter("status", Constants.Status.ACT);

		try {
			cities = query.getResultList();
		} catch (NoResultException ex) {
			System.out.println("no results found");
		}
		return cities;
	}

	@Override
	public SearchBusResponseDTO searchBusAvailability(final SearchBusRequestDTO searchBusRequestDTO) {

		SearchBusResponseDTO searchBusResponseDTO = new SearchBusResponseDTO();

		// SQL query
		StringBuilder querySB = new StringBuilder();
		querySB.append("select a.bus_id, a.from_city_id, c.city_name from_city_name, ");
		querySB.append("    a.to_city_id, d.city_name to_city_name, a.route_code, ");
		querySB.append("    a.dep_datetime, a.arr_datetime, a.ticket_price, b.seats_available ");
		querySB.append("from ");
		querySB.append("    TBL_BUS a, ");
		querySB.append("    TBL_INVENTORY b, ");
		querySB.append("    TBL_CITY c, ");
		querySB.append("    TBL_CITY d ");
		querySB.append("where ");
		querySB.append("    a.bus_id = b.bus_id ");
		querySB.append("    and a.from_city_id = c.city_id ");
		querySB.append("    and a.to_city_id = d.city_id ");
		querySB.append("    and a.from_city_id = :fromCityId ");
		querySB.append("    and a.to_city_id = :toCityId ");
		querySB.append("    and date(a.dep_datetime) >= :depDateFrom ");
		querySB.append("    and date(a.dep_datetime) <= :depDateTo ");
		querySB.append("    and a.status = 'ACT';");

		// Query parameters
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("fromCityId", searchBusRequestDTO.getFromCityId(), Types.INTEGER);
		queryParams.addValue("toCityId", searchBusRequestDTO.getToCityId(), Types.INTEGER);
		queryParams.addValue("depDateFrom", searchBusRequestDTO.getDepartureFromDate(), Types.DATE);
		queryParams.addValue("depDateTo", searchBusRequestDTO.getDepartureToDate(), Types.DATE);

		RowMapper<BusDTO> rowMapper = new RowMapper<BusDTO>() {
			public BusDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusDTO busDTO = new BusDTO();
				busDTO.setBusId(rs.getLong("bus_id"));
				busDTO.setFromCityId(rs.getLong("from_city_id"));
				busDTO.setFromCity(rs.getString("from_city_name"));
				busDTO.setToCityId(rs.getLong("to_city_id"));
				busDTO.setToCity(rs.getString("to_city_name"));
				busDTO.setRouteCode(rs.getString("route_code"));
				busDTO.setDepartureDateTime(rs.getTimestamp("dep_datetime"));
				busDTO.setArrivalDateTime(rs.getTimestamp("arr_datetime"));
				busDTO.setPerPassengerPrice(rs.getBigDecimal("ticket_price"));
				busDTO.setAvailable(rs.getInt("seats_available") >=
					                    searchBusRequestDTO.getNoOfPassengers() ? true : false);
				return busDTO;
			}
		};

		List<BusDTO> availableBuses = getNamedParameterJdbcTemplate().query(querySB.toString(), queryParams, rowMapper);
		if (availableBuses != null) {
			searchBusResponseDTO.setAvailableBusList(availableBuses);
		}
		return searchBusResponseDTO;
	}

	@Override
	public BookBusResponseDTO bookBus(BookBusRequestDTO bookBusRequestDTO) throws ApplicationException {
		// Load locking the inventory and update
		String jpaQuery = "SELECT a FROM Inventory a WHERE a.busId = :busId";
		TypedQuery<Inventory> query = this.em.createQuery(jpaQuery, Inventory.class);
		query.setParameter("busId", bookBusRequestDTO.getBusId());
		query.setLockMode(LockModeType.PESSIMISTIC_READ);
		query.setHint("javax.persistence.lock.timeout", "10000"); // lock timeout in ms
		Inventory inventory = query.getSingleResult();

		if (inventory.getSeatsAvailable() < bookBusRequestDTO.getNoOfPassengers()) {
			throw new ApplicationException("Not enough seats available");
		}

		inventory.setSeatsBooked(inventory.getSeatsBooked() + bookBusRequestDTO.getNoOfPassengers());
		inventory.setSeatsAvailable(inventory.getSeatsAvailable() - bookBusRequestDTO.getNoOfPassengers());
		this.em.persist(inventory);

		// Create booking
		Booking booking = new Booking();
		booking.setBookingReference(
			RandomStringUtils.randomAlphanumeric(6).toUpperCase()); //TODO: validate if already used
		booking.setBookedDateTime(new Date());
		booking.setBusId(bookBusRequestDTO.getBusId());
		booking.setBookedSeats(bookBusRequestDTO.getNoOfPassengers());
		booking.setContactName(bookBusRequestDTO.getContactPerson());
		booking.setContactPhone(bookBusRequestDTO.getContactPhone());
		booking.setTotalPrice(bookBusRequestDTO.getTotalPrice());

		if (bookBusRequestDTO.getPayNow()) {
			booking.setTotalPaid(bookBusRequestDTO.getCardPaymentDetails().getTotalAmountPaid());
			booking.setStatus(Constants.BookingStatus.CNF);
		} else {
			booking.setTotalPaid(new BigDecimal(0));
			booking.setStatus(Constants.BookingStatus.OHD);
		}
		this.em.persist(booking);

		BookBusResponseDTO responseDTO = new BookBusResponseDTO();
		responseDTO.setBookId(booking.getBookingId());
		responseDTO.setBusDetails(getBusById(booking.getBusId()));
		responseDTO.setBookingReference(booking.getBookingReference());
		responseDTO.setBookedDateTime(booking.getBookedDateTime());
		responseDTO.setContactPhone(booking.getContactPhone());
		responseDTO.setContactPerson(booking.getContactName());
		responseDTO.setBookingStatus(booking.getStatus());
		responseDTO.setNoOfPassengers(booking.getBookedSeats());
		responseDTO.setTotalPrice(booking.getTotalPrice());
		responseDTO.setTotalPaid(booking.getTotalPaid());
		responseDTO.setVersion(booking.getVersion());

		return responseDTO;
	}

	private BusDTO getBusById(final Long busId) {

		// SQL query
		StringBuilder querySB = new StringBuilder();
		querySB.append("select a.bus_id, a.from_city_id, c.city_name from_city_name, ");
		querySB.append("    a.to_city_id, d.city_name to_city_name, a.route_code, ");
		querySB.append("    a.dep_datetime, a.arr_datetime, a.ticket_price, b.seats_available ");
		querySB.append("from ");
		querySB.append("    TBL_BUS a, ");
		querySB.append("    TBL_INVENTORY b, ");
		querySB.append("    TBL_CITY c, ");
		querySB.append("    TBL_CITY d ");
		querySB.append("where ");
		querySB.append("    a.bus_id = b.bus_id ");
		querySB.append("    and a.from_city_id = c.city_id ");
		querySB.append("    and a.to_city_id = d.city_id ");
		querySB.append("    and a.bus_Id = :busId ");

		// Query parameters
		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("busId", busId, Types.INTEGER);

		RowMapper<BusDTO> rowMapper = new RowMapper<BusDTO>() {
			public BusDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BusDTO busDTO = new BusDTO();
				busDTO.setBusId(rs.getLong("bus_id"));
				busDTO.setFromCityId(rs.getLong("from_city_id"));
				busDTO.setFromCity(rs.getString("from_city_name"));
				busDTO.setToCityId(rs.getLong("to_city_id"));
				busDTO.setToCity(rs.getString("to_city_name"));
				busDTO.setRouteCode(rs.getString("route_code"));
				busDTO.setDepartureDateTime(rs.getTimestamp("dep_datetime"));
				busDTO.setArrivalDateTime(rs.getTimestamp("arr_datetime"));
				busDTO.setPerPassengerPrice(rs.getBigDecimal("ticket_price"));
				busDTO.setAvailable(rs.getInt("seats_available") >= 0 ? true : false);
				return busDTO;
			}
		};

		return getNamedParameterJdbcTemplate().queryForObject(querySB.toString(), queryParams, rowMapper);
	}
}
