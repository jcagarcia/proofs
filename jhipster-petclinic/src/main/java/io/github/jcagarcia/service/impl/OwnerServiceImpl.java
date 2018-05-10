package io.github.jcagarcia.service.impl;

import io.github.jcagarcia.service.OwnerService;
import io.github.jcagarcia.domain.Owner;
import io.github.jcagarcia.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Owner.
 */
@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final Logger log = LoggerFactory.getLogger(OwnerServiceImpl.class);

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     * Save a owner.
     *
     * @param owner the entity to save
     * @return the persisted entity
     */
    @Override
    public Owner save(Owner owner) {
        log.debug("Request to save Owner : {}", owner);
        return ownerRepository.save(owner);
    }

    /**
     * Get all the owners.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        log.debug("Request to get all Owners");
        return ownerRepository.findAll();
    }

    /**
     * Get one owner by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Owner findOne(Long id) {
        log.debug("Request to get Owner : {}", id);
        return ownerRepository.findOne(id);
    }

    /**
     * Delete the owner by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Owner : {}", id);
        ownerRepository.delete(id);
    }
}
