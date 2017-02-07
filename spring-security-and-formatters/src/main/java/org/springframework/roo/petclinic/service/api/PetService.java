package org.springframework.roo.petclinic.service.api;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;
import org.springframework.roo.petclinic.domain.reference.PetType;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = PetService
 *
 * TODO Auto-generated class documentation
 *
 */
public interface PetService extends EntityResolver<Pet, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public abstract Pet findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    public abstract void delete(Pet pet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Pet> save(Iterable<Pet> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    public abstract Pet save(Pet entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public abstract Pet findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Pet> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Pet> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToAdd
     * @return Pet
     */
    public abstract Pet addToVisits(Pet pet, Iterable<Long> visitsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToRemove
     * @return Pet
     */
    public abstract Pet removeFromVisits(Pet pet, Iterable<Long> visitsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visits
     * @return Pet
     */
    public abstract Pet setVisits(Pet pet, Iterable<Long> visits);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByOwner(Owner owner, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return Long
     */
    public abstract long countByOwner(Owner owner);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByOwner(Owner owner, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByTypeAndNameLike(PetType type, String name, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByNameAndWeight(PetNameAndWeightFormBean formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @return Long
     */
    public abstract long countBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @return Long
     */
    public abstract long countByTypeAndNameLike(PetType type, String name);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByNameAndWeight(PetNameAndWeightFormBean formBean);
}
