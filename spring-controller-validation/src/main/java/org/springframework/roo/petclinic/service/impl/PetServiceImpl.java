package org.springframework.roo.petclinic.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;

import java.util.List;

/**
 * = PetServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = PetService.class)
public class PetServiceImpl implements PetService {

    /**
     * {@inheritDoc}
     *
     * @param name
     * @return
     */
    @Override
    public List<Pet> findByName(String name) {
        return getPetRepository().findByName(name);
    }
}
