package org.springframework.roo.petclinic.service.api;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.roo.petclinic.domain.Pet;

import java.util.List;

/**
 * = PetService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Pet.class)
public interface PetService {

    /**
     * Defines an operation to obtain an entity by its name
     *
     * @param name
     * @return
     */
    List<Pet> findByName(String name);
}
