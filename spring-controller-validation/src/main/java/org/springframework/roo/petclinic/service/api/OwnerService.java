package org.springframework.roo.petclinic.service.api;

import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.roo.petclinic.domain.Owner;

import java.util.List;

/**
 * = OwnerService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Owner.class)
public interface OwnerService<T> extends ValidatorService<T>{

    /**
     * Defines an operation to obtain an entity by its name
     *
     * @param name
     * @return
     */
    List<Owner> findByName(String name);

    /**
     * Defines an operation to check if some Owner exists by name. Also, if
     * some record is obtained but you don't want to take it in account,
     * include the id of this element in the exclusions parameter.
     *
     * @param name The name of the owner that you are looking for.
     * @param exclusions The ids that want to be excluded from the validation
     * @return true if exists some record with the same name
     */
    boolean exists(String name, Long... exclusions);
}
