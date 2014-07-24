package com.proavos.training.onlinetkt.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class BaseJPADAOImpl {

    @PersistenceContext
    protected EntityManager em;
}
