package com.audit.automator.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

@Repository
public class DataRepository extends AbstractBaseRepository{

    protected static final Logger logger = LoggerFactory.getLogger(DataRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    protected CriteriaBuilder criteriaBuilder;


    @PostConstruct
    public void init() {
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }


}
