package org.springframework.roo.petclinic.service.api;

import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.roo.petclinic.domain.Pet;

import java.util.List;

/**
 * = PetService
 * <p>
 * TODO Auto-generated class documentation
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

    /**
     * Defines an operation to check if some Pet exists by name. Also, if
     * some record is obtained but you don't want to take it in account,
     * include the id of this element in the exclusions parameter.
     *
     * @param name The name of the pet that you are looking for.
     * @param exclusions The ids that want to be excluded from the validation
     * @return true if exists some record with the same name
     */
    boolean exists(String name, Long... exclusions);
}
