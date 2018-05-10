package io.github.jcagarcia.service.impl;

import io.github.jcagarcia.service.VisitService;
import io.github.jcagarcia.domain.Visit;
import io.github.jcagarcia.repository.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Visit.
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final Logger log = LoggerFactory.getLogger(VisitServiceImpl.class);

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Save a visit.
     *
     * @param visit the entity to save
     * @return the persisted entity
     */
    @Override
    public Visit save(Visit visit) {
        log.debug("Request to save Visit : {}", visit);
        return visitRepository.save(visit);
    }

    /**
     * Get all the visits.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Visit> findAll() {
        log.debug("Request to get all Visits");
        return visitRepository.findAll();
    }

    /**
     * Get one visit by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Visit findOne(Long id) {
        log.debug("Request to get Visit : {}", id);
        return visitRepository.findOne(id);
    }

    /**
     * Delete the visit by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Visit : {}", id);
        visitRepository.delete(id);
    }
}
