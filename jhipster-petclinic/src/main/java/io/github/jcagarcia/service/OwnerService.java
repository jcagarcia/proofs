package io.github.jcagarcia.service;

import io.github.jcagarcia.domain.Owner;
import java.util.List;

/**
 * Service Interface for managing Owner.
 */
public interface OwnerService {

    /**
     * Save a owner.
     *
     * @param owner the entity to save
     * @return the persisted entity
     */
    Owner save(Owner owner);

    /**
     * Get all the owners.
     *
     * @return the list of entities
     */
    List<Owner> findAll();

    /**
     * Get the "id" owner.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Owner findOne(Long id);

    /**
     * Delete the "id" owner.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
