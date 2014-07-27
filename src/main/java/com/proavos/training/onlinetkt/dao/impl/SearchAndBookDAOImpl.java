package com.proavos.training.onlinetkt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.proavos.training.onlinetkt.common.BaseJPADAOImpl;
import com.proavos.training.onlinetkt.common.Constants;
import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
import com.proavos.training.onlinetkt.dto.BookBusRequestDTO;
import com.proavos.training.onlinetkt.dto.BookBusResponseDTO;
import com.proavos.training.onlinetkt.dto.BusDTO;
import com.proavos.training.onlinetkt.dto.SearchBusRequestDTO;
import com.proavos.training.onlinetkt.dto.SearchBusResponseDTO;
import com.proavos.training.onlinetkt.model.City;

@Named
@ApplicationScoped
public class SearchAndBookDAOImpl extends BaseJPADAOImpl implements SearchAndBookDAO {

	@Override
	public List<City> getAllActiveCities() {
		List<City> cities = Collections.emptyList();

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

		StringBuilder querySB = new StringBuilder();
		querySB.append("select a.bus_id, a.from_city_id, c.city_name from_city_name, " );
		querySB.append("    a.to_city_id, d.city_name to_city_name, a.route_code, " );
		querySB.append("    a.dep_datetime, a.arr_datetime, a.ticket_price, b.seats_available " );
		querySB.append("from " );
		querySB.append("    TBL_BUS a, " );
		querySB.append("    TBL_INVENTORY b, " );
		querySB.append("    TBL_CITY c, " );
		querySB.append("    TBL_CITY d " );
		querySB.append("where " );
		querySB.append("    a.bus_id = b.bus_id " );
		querySB.append("    and a.from_city_id = c.city_id " );
		querySB.append("    and a.to_city_id = d.city_id " );
		querySB.append("    and a.from_city_id = :fromCityId " );
		querySB.append("    and a.to_city_id = :toCityId " );
		querySB.append("    and date(a.dep_datetime) = :depDate " );
		querySB.append("    and a.status = 'ACT';");

		MapSqlParameterSource queryParams = new MapSqlParameterSource();
		queryParams.addValue("fromCityId", searchBusRequestDTO.getFromCityId(), Types.INTEGER);
		queryParams.addValue("toCityId", searchBusRequestDTO.getToCityId(), Types.INTEGER);
		queryParams.addValue("depDate", searchBusRequestDTO.getDepatureDate(), Types.DATE);

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
				busDTO.setAvailable(rs.getInt("seats_available")>=
					searchBusRequestDTO.getNoOfPassengers() ? true : false);
				return busDTO;
			}
		};

		List<BusDTO> availableBuses = getNamedParameterJdbcTemplate().query(querySB.toString(), queryParams, rowMapper);
		if (availableBuses != null){
			searchBusResponseDTO.setAvailableBusList(availableBuses);
		}
		return searchBusResponseDTO;
	}

	@Override
	public BookBusResponseDTO bookBus(BookBusRequestDTO bookBusRequestDTO) {
		return null;
	}
}
