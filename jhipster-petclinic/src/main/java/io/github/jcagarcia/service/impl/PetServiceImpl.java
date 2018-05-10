package io.github.jcagarcia.service.impl;

import io.github.jcagarcia.service.PetService;
import io.github.jcagarcia.domain.Pet;
import io.github.jcagarcia.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Pet.
 */
@Service
@Transactional
public class PetServiceImpl implements PetService {

    private final Logger log = LoggerFactory.getLogger(PetServiceImpl.class);

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * Save a pet.
     *
     * @param pet the entity to save
     * @return the persisted entity
     */
    @Override
    public Pet save(Pet pet) {
        log.debug("Request to save Pet : {}", pet);
        return petRepository.save(pet);
    }

    /**
     * Get all the pets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Pet> findAll() {
        log.debug("Request to get all Pets");
        return petRepository.findAll();
    }

    /**
     * Get one pet by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Pet findOne(Long id) {
        log.debug("Request to get Pet : {}", id);
        return petRepository.findOne(id);
    }

    /**
     * Delete the pet by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Pet : {}", id);
        petRepository.delete(id);
    }
}
