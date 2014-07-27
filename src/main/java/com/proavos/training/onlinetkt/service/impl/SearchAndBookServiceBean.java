package com.proavos.training.onlinetkt.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.proavos.training.onlinetkt.common.ApplicationException;
import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
import com.proavos.training.onlinetkt.dto.BookBusRequestDTO;
import com.proavos.training.onlinetkt.dto.BookBusResponseDTO;
import com.proavos.training.onlinetkt.dto.SearchBusRequestDTO;
import com.proavos.training.onlinetkt.dto.SearchBusResponseDTO;
import com.proavos.training.onlinetkt.model.City;
import com.proavos.training.onlinetkt.service.SearchAndBookServiceLocal;
import com.proavos.training.onlinetkt.service.SearchAndBookServiceRemote;

@Stateless
public class SearchAndBookServiceBean implements SearchAndBookServiceRemote, SearchAndBookServiceLocal {

	@Inject
	SearchAndBookDAO searchAndBookDAO;

	@Override
	public String echo(String requestMessage) {
        StringBuffer sb = new StringBuffer(requestMessage).append(" [").append(new Date()).append("]");
        return sb.toString();
	}

	@Override
	public List<City> getAllActiveCities() {
		return searchAndBookDAO.getAllActiveCities();
	}

	@Override
	public SearchBusResponseDTO searchBusAvailability(SearchBusRequestDTO searchBusRequestDTO) {
		return searchAndBookDAO.searchBusAvailability(searchBusRequestDTO);
	}

	@Override
	public BookBusResponseDTO bookBus(BookBusRequestDTO bookBusRequestDTO) throws ApplicationException {
		// TODO: validate request data including price
		// TODO: process payment
		return searchAndBookDAO.bookBus(bookBusRequestDTO);
	}
}
