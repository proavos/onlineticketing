package com.proavos.training.onlinetkt.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
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

		List<City> cities = searchAndBookDAO.getAllActiveCities();
		if (cities != null) {
			System.out.println("No of cities found = " + cities.size());
		}

        return sb.toString();
	}
}
