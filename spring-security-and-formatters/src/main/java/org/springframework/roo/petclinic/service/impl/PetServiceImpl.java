package org.springframework.roo.petclinic.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.domain.reference.PetType;
import org.springframework.roo.petclinic.repository.PetRepository;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.roo.petclinic.service.api.VisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = PetServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class PetServiceImpl implements PetService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VisitService visitService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetRepository petRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param petRepository
     * @param visitService
     */
    @Autowired
    public PetServiceImpl(PetRepository petRepository, @Lazy VisitService visitService) {
        setPetRepository(petRepository);
        setVisitService(visitService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetRepository
     */
    public PetRepository getPetRepository() {
        return petRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petRepository
     */
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VisitService
     */
    public VisitService getVisitService() {
        return visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitService
     */
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToAdd
     * @return Pet
     */
    @Transactional
    public Pet addToVisits(Pet pet, Iterable<Long> visitsToAdd) {
        List<Visit> visits = getVisitService().findAll(visitsToAdd);
        pet.addToVisits(visits);
        return getPetRepository().save(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToRemove
     * @return Pet
     */
    @Transactional
    public Pet removeFromVisits(Pet pet, Iterable<Long> visitsToRemove) {
        List<Visit> visits = getVisitService().findAll(visitsToRemove);
        pet.removeFromVisits(visits);
        return getPetRepository().save(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visits
     * @return Pet
     */
    @Transactional
    public Pet setVisits(Pet pet, Iterable<Long> visits) {
        List<Visit> items = getVisitService().findAll(visits);
        Set<Visit> currents = pet.getVisits();
        Set<Visit> toRemove = new HashSet<Visit>();
        for (Iterator<Visit> iterator = currents.iterator(); iterator.hasNext(); ) {
            Visit nextVisit = iterator.next();
            if (items.contains(nextVisit)) {
                items.remove(nextVisit);
            } else {
                toRemove.add(nextVisit);
            }
        }
        pet.removeFromVisits(toRemove);
        pet.addToVisits(items);
        return getPetRepository().save(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    @Transactional
    public void delete(Pet pet) {
        // Clear bidirectional many-to-one child relationship with Owner
        if (pet.getOwner() != null) {
            pet.getOwner().getPets().remove(pet);
        }
        // Clear bidirectional one-to-many parent relationship with Visit
        for (Visit item : pet.getVisits()) {
            item.setPet(null);
        }
        getPetRepository().delete(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Pet> save(Iterable<Pet> entities) {
        return getPetRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Pet> toDelete = getPetRepository().findAll(ids);
        getPetRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    @Transactional
    public Pet save(Pet entity) {
        return getPetRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOne(Long id) {
        return getPetRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOneForUpdate(Long id) {
        return getPetRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Pet> findAll(Iterable<Long> ids) {
        return getPetRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Pet> findAll() {
        return getPetRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPetRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPetRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByOwner(Owner owner, GlobalSearch globalSearch, Pageable pageable) {
        return getPetRepository().findByOwner(owner, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return Long
     */
    public long countByOwner(Owner owner) {
        return getPetRepository().countByOwner(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByOwner(Owner owner, Pageable pageable) {
        return getPetRepository().findByOwner(owner, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @param pageable
     * @return Page
     */
    public Page<Pet> findBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight, Pageable pageable) {
        return getPetRepository().findBySendRemindersAndWeightLessThan(sendReminders, weight, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByTypeAndNameLike(PetType type, String name, Pageable pageable) {
        return getPetRepository().findByTypeAndNameLike(type, name, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByNameAndWeight(PetNameAndWeightFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getPetRepository().findByNameAndWeight(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @return Long
     */
    public long countBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight) {
        return getPetRepository().countBySendRemindersAndWeightLessThan(sendReminders, weight);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @return Long
     */
    public long countByTypeAndNameLike(PetType type, String name) {
        return getPetRepository().countByTypeAndNameLike(type, name);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByNameAndWeight(PetNameAndWeightFormBean formBean) {
        return getPetRepository().countByNameAndWeight(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Pet> getEntityType() {
        return Pet.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
