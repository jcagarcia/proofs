package io.github.jcagarcia.service;

import io.github.jcagarcia.domain.Vet;
import java.util.List;

/**
 * Service Interface for managing Vet.
 */
public interface VetService {

    /**
     * Save a vet.
     *
     * @param vet the entity to save
     * @return the persisted entity
     */
    Vet save(Vet vet);

    /**
     * Get all the vets.
     *
     * @return the list of entities
     */
    List<Vet> findAll();

    /**
     * Get the "id" vet.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Vet findOne(Long id);

    /**
     * Delete the "id" vet.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
