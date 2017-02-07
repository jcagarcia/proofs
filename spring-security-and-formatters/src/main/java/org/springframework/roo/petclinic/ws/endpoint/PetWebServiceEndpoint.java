package org.springframework.roo.petclinic.ws.endpoint;
import java.util.List;

import javax.jws.WebService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;
import org.springframework.roo.petclinic.domain.reference.PetType;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.roo.petclinic.ws.api.PetWebService;

import io.springlets.data.domain.GlobalSearch;

/**
 * = PetWebServiceEndpoint
 *
 * TODO Auto-generated class documentation
 *
 */
@WebService(endpointInterface = "org.springframework.roo.petclinic.ws.api.PetWebService", portName = "PetWebServicePort", serviceName = "PetWebService", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
public class PetWebServiceEndpoint implements PetWebService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetService petService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param petService
     */
    public PetWebServiceEndpoint(PetService petService) {
        setPetService(petService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetService
     */
    public PetService getPetService() {
        return petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petService
     */
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToAdd
     * @return Pet
     */
    public Pet addToVisitsByPetAndIterable(Pet pet, Iterable<Long> visitsToAdd) {
        return getPetService().addToVisits(pet, visitsToAdd);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPetService().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @return Long
     */
    public long countByBooleanAndFloat(boolean sendReminders, Float weight) {
        return getPetService().countBySendRemindersAndWeightLessThan(sendReminders, weight);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return Long
     */
    public long countByOwner(Owner owner) {
        return getPetService().countByOwner(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByPetNameAndWeightFormBean(PetNameAndWeightFormBean formBean) {
        return getPetService().countByNameAndWeight(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @return Long
     */
    public long countByPetTypeAndString(PetType type, String name) {
        return getPetService().countByTypeAndNameLike(type, name);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public void deleteByIterable(Iterable<Long> ids) {
        getPetService().delete(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    public void deleteByPet(Pet pet) {
        getPetService().delete(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Pet> findAll() {
        return getPetService().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findAllByGlobalSearchAndPageable(GlobalSearch globalSearch, Pageable pageable) {
        return getPetService().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Pet> findAllByIterable(Iterable<Long> ids) {
        return getPetService().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByBooleanAndFloatAndPageable(boolean sendReminders, Float weight, Pageable pageable) {
        return getPetService().findBySendRemindersAndWeightLessThan(sendReminders, weight, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByOwnerAndGlobalSearchAndPageable(Owner owner, GlobalSearch globalSearch, Pageable pageable) {
        return getPetService().findByOwner(owner, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByOwnerAndPageable(Owner owner, Pageable pageable) {
        return getPetService().findByOwner(owner, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByPetNameAndWeightFormBeanAndGlobalSearchAndPageable(PetNameAndWeightFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getPetService().findByNameAndWeight(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByPetTypeAndStringAndPageable(PetType type, String name, Pageable pageable) {
        return getPetService().findByTypeAndNameLike(type, name, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOneByLong(Long id) {
        return getPetService().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOneForUpdateByLong(Long id) {
        return getPetService().findOneForUpdate(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visitsToRemove
     * @return Pet
     */
    public Pet removeFromVisitsByPetAndIterable(Pet pet, Iterable<Long> visitsToRemove) {
        return getPetService().removeFromVisits(pet, visitsToRemove);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public List<Pet> saveByIterable(Iterable<Pet> entities) {
        return getPetService().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    public Pet saveByPet(Pet entity) {
        return getPetService().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param visits
     * @return Pet
     */
    public Pet setVisitsByPetAndIterable(Pet pet, Iterable<Long> visits) {
        return getPetService().setVisits(pet, visits);
    }
}
