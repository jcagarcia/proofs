package com.springsource.petclinic.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.springsource.petclinic.model.Vet;

/**
 * = VetRepositoryImpl
 *
 * Implementation of VetRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = VetRepositoryCustom.class)
public class VetRepositoryImpl extends QueryDslRepositorySupportExt<Vet> implements VetRepositoryCustom{

    /**
     * Default constructor
     */
    VetRepositoryImpl() {
        super(Vet.class);
    }
}