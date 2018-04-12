package org.springframework.roo.petclinic.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.roo.petclinic.domain.Owner;

/**
 * = OwnerRepositoryImpl
 *
 * Implementation of OwnerRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = OwnerRepositoryCustom.class)
public class OwnerRepositoryImpl extends QueryDslRepositorySupportExt<Owner> implements OwnerRepositoryCustom{

    /**
     * Default constructor
     */
    OwnerRepositoryImpl() {
        super(Owner.class);
    }
}