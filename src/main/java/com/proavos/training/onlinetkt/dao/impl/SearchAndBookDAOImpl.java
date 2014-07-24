package com.proavos.training.onlinetkt.dao.impl;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.proavos.training.onlinetkt.common.BaseJPADAOImpl;
import com.proavos.training.onlinetkt.common.Constants;
import com.proavos.training.onlinetkt.dao.SearchAndBookDAO;
import com.proavos.training.onlinetkt.model.City;

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
}
