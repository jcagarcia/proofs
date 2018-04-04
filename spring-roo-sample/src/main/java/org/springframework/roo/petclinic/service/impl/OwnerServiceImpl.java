package org.springframework.roo.petclinic.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorization;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorizations;
import org.springframework.roo.petclinic.domain.Owner;
import io.springlets.data.domain.GlobalSearch;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.repository.OwnerRepository;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = OwnerServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = OwnerService.class)
@RooSecurityAuthorizations(authorizations = { @RooSecurityAuthorization(method = "delete", parameters = { Owner.class }, roles = "ADMIN"), @RooSecurityAuthorization(method = "delete", parameters = { Iterable.class }, roles = "ADMIN") })
@Service
@Transactional(readOnly = true)
public class OwnerServiceImpl implements OwnerService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OwnerRepository ownerRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetService petService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param ownerRepository
     * @param petService
     */
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, @Lazy PetService petService) {
        setOwnerRepository(ownerRepository);
        setPetService(petService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OwnerRepository
     */
    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ownerRepository
     */
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
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
     * @param owner
     * @param petsToAdd
     * @return Owner
     */
    @Transactional
    public Owner addToPets(Owner owner, Iterable<Long> petsToAdd) {
        List<Pet> pets = getPetService().findAll(petsToAdd);
        owner.addToPets(pets);
        return getOwnerRepository().save(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return Owner
     */
    @Transactional
    public Owner removeFromPets(Owner owner, Iterable<Long> petsToRemove) {
        List<Pet> pets = getPetService().findAll(petsToRemove);
        owner.removeFromPets(pets);
        return getOwnerRepository().save(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pets
     * @return Owner
     */
    @Transactional
    public Owner setPets(Owner owner, Iterable<Long> pets) {
        List<Pet> items = getPetService().findAll(pets);
        Set<Pet> currents = owner.getPets();
        Set<Pet> toRemove = new HashSet<Pet>();
        for (Iterator<Pet> iterator = currents.iterator(); iterator.hasNext(); ) {
            Pet nextPet = iterator.next();
            if (items.contains(nextPet)) {
                items.remove(nextPet);
            } else {
                toRemove.add(nextPet);
            }
        }
        owner.removeFromPets(toRemove);
        owner.addToPets(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        owner.setVersion(owner.getVersion() + 1);
        return getOwnerRepository().save(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     */
    @Transactional
    public void delete(Owner owner) {
        // Clear bidirectional one-to-many parent relationship with Pet
        for (Pet item : owner.getPets()) {
            item.setOwner(null);
        }
        getOwnerRepository().delete(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Owner> save(Iterable<Owner> entities) {
        return getOwnerRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Owner> toDelete = getOwnerRepository().findAll(ids);
        getOwnerRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Owner
     */
    @Transactional
    public Owner save(Owner entity) {
        return getOwnerRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public Owner findOne(Long id) {
        return getOwnerRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public Owner findOneForUpdate(Long id) {
        return getOwnerRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Owner> findAll(Iterable<Long> ids) {
        return getOwnerRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Owner> findAll() {
        return getOwnerRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getOwnerRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findByFirstNameLike(OwnerFirstNameFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerRepository().findByFirstNameLike(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OwnerInfo> findByCityLike(OwnerCityFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerRepository().findByCityLike(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByFirstNameLike(OwnerFirstNameFormBean formBean) {
        return getOwnerRepository().countByFirstNameLike(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByCityLike(OwnerCityFormBean formBean) {
        return getOwnerRepository().countByCityLike(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Owner> getEntityType() {
        return Owner.class;
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
