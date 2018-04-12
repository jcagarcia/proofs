package org.springframework.roo.petclinic.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.roo.petclinic.domain.Pet;

/**
 * = PetRepositoryImpl
 *
 * Implementation of PetRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = PetRepositoryCustom.class)
public class PetRepositoryImpl extends QueryDslRepositorySupportExt<Pet> implements PetRepositoryCustom{

    /**
     * Default constructor
     */
    PetRepositoryImpl() {
        super(Pet.class);
    }
}