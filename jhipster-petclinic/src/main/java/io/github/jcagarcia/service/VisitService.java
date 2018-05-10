package io.github.jcagarcia.service;

import io.github.jcagarcia.domain.Visit;
import java.util.List;

/**
 * Service Interface for managing Visit.
 */
public interface VisitService {

    /**
     * Save a visit.
     *
     * @param visit the entity to save
     * @return the persisted entity
     */
    Visit save(Visit visit);

    /**
     * Get all the visits.
     *
     * @return the list of entities
     */
    List<Visit> findAll();

    /**
     * Get the "id" visit.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Visit findOne(Long id);

    /**
     * Delete the "id" visit.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
