package io.github.jcagarcia.service.impl;

import io.github.jcagarcia.service.VetService;
import io.github.jcagarcia.domain.Vet;
import io.github.jcagarcia.repository.VetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Vet.
 */
@Service
@Transactional
public class VetServiceImpl implements VetService {

    private final Logger log = LoggerFactory.getLogger(VetServiceImpl.class);

    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    /**
     * Save a vet.
     *
     * @param vet the entity to save
     * @return the persisted entity
     */
    @Override
    public Vet save(Vet vet) {
        log.debug("Request to save Vet : {}", vet);
        return vetRepository.save(vet);
    }

    /**
     * Get all the vets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Vet> findAll() {
        log.debug("Request to get all Vets");
        return vetRepository.findAll();
    }

    /**
     * Get one vet by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Vet findOne(Long id) {
        log.debug("Request to get Vet : {}", id);
        return vetRepository.findOne(id);
    }

    /**
     * Delete the vet by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Vet : {}", id);
        vetRepository.delete(id);
    }
}
