package com.springsource.petclinic.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.springsource.petclinic.model.Visit;

/**
 * = VisitRepositoryImpl
 *
 * Implementation of VisitRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = VisitRepositoryCustom.class)
public class VisitRepositoryImpl extends QueryDslRepositorySupportExt<Visit> implements VisitRepositoryCustom{

    /**
     * Default constructor
     */
    VisitRepositoryImpl() {
        super(Visit.class);
    }
}