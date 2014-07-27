package com.proavos.training.onlinetkt.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
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

	public void testSearchBusAvailability(){
		SearchBusRequestDTO searchBusRequestDTO = new SearchBusRequestDTO();
		searchBusRequestDTO.setFromCityId(new Long(1));
		searchBusRequestDTO.setToCityId(new Long(2));
		searchBusRequestDTO.setNoOfPassengers(1);

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		searchBusRequestDTO.setDepatureDate(calendar.getTime());

		SearchBusResponseDTO response = searchAndBookDAO.searchBusAvailability(searchBusRequestDTO);
		Assert.isTrue(response.getAvailableBusList().size()>0, "Empty response returned");
		for (BusDTO busDTO : response.getAvailableBusList()){
			System.out.println(busDTO.toString());
		}
	}

}