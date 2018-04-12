package org.springframework.roo.petclinic.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.roo.petclinic.domain.Visit;

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