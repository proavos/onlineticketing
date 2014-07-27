package com.proavos.training.onlinetkt.common;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class BaseJPADAOImpl extends JdbcDaoSupport {

    @PersistenceContext
    protected EntityManager em;

	@Resource(lookup = "java:/onlineTicketingDS")
	private DataSource dataSource;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostConstruct
	public void init() {
		this.setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return this.namedParameterJdbcTemplate;
	}
}
