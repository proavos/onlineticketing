package com.proavos.training.onlinetkt.dao.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.proavos.training.onlinetkt.common.ApplicationException;
import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
import com.proavos.training.onlinetkt.dto.BookBusRequestDTO;
import com.proavos.training.onlinetkt.dto.BookBusResponseDTO;
import com.proavos.training.onlinetkt.dto.BusDTO;
import com.proavos.training.onlinetkt.dto.SearchBusRequestDTO;
import com.proavos.training.onlinetkt.dto.SearchBusResponseDTO;
import com.proavos.training.onlinetkt.model.City;

@Test
@ContextConfiguration(locations = {"classpath:testBusinessAppContext.xml"})
public class SearchAndBookDAOImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Inject
    SearchAndBookDAO searchAndBookDAO;

    public void testGetAllActiveCities() {
        Assert.notNull(searchAndBookDAO, "SearchAndBookDAO injection failed");
        List<City> allCities = searchAndBookDAO.getAllActiveCities();
        Assert.notNull(allCities, "Cities retrieval failed");
    }

	@Rollback (false)
	public void testSearchBusAvailabilityAndBook(){
		SearchBusRequestDTO searchBusRequestDTO = new SearchBusRequestDTO();
		searchBusRequestDTO.setFromCityId(new Long(1));
		searchBusRequestDTO.setToCityId(new Long(2));
		searchBusRequestDTO.setNoOfPassengers(1);

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		searchBusRequestDTO.setDepartureFromDate(calendar.getTime());

		SearchBusResponseDTO response = searchAndBookDAO.searchBusAvailability(searchBusRequestDTO);
		Assert.isTrue(response.getAvailableBusList().size()>0, "Empty response returned");
		for (BusDTO busDTO : response.getAvailableBusList()){
			System.out.println(busDTO.toString());
		}

		BusDTO busToBook = response.getAvailableBusList().get(0);
		BookBusRequestDTO bookRequest = new BookBusRequestDTO();
		bookRequest.setBusId(busToBook.getBusId());
		bookRequest.setNoOfPassengers(1);
		bookRequest.setContactPerson("John Doe");
		bookRequest.setContactPhone("0774123456");
		bookRequest.setTotalPrice(busToBook.getPerPassengerPrice());
		bookRequest.setPayNow(false);

		BookBusResponseDTO bookResponse = null;
		try {
			bookResponse = searchAndBookDAO.bookBus(bookRequest);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		Assert.notNull(bookResponse, "Booking failed");
		System.out.println(bookResponse.toString());
	}

}