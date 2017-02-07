package org.springframework.roo.petclinic.ws.endpoint;
import java.util.List;

import javax.jws.WebService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.petclinic.ws.api.OwnerWebService;

import io.springlets.data.domain.GlobalSearch;

/**
 * = OwnerWebServiceEndpoint
 *
 * TODO Auto-generated class documentation
 *
 */
@WebService(endpointInterface = "org.springframework.roo.petclinic.ws.api.OwnerWebService", portName = "OwnerWebServicePort", serviceName = "OwnerWebService", targetNamespace = "http://ws.petclinic.roo.springframework.org/")
public class OwnerWebServiceEndpoint implements OwnerWebService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OwnerService ownerService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param ownerService
     */
    public OwnerWebServiceEndpoint(OwnerService ownerService) {
        setOwnerService(ownerService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OwnerService
     */
    public OwnerService getOwnerService() {
        return ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ownerService
     */
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToAdd
     * @return Owner
     */
    public Owner addToPetsByOwnerAndIterable(Owner owner, Iterable<Long> petsToAdd) {
        return getOwnerService().addToPets(owner, petsToAdd);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getOwnerService().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByOwnerCityFormBean(OwnerCityFormBean formBean) {
        return getOwnerService().countByCityLike(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByOwnerFirstNameFormBean(OwnerFirstNameFormBean formBean) {
        return getOwnerService().countByFirstNameLike(formBean);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public void deleteByIterable(Iterable<Long> ids) {
        getOwnerService().delete(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     */
    public void deleteByOwner(Owner owner) {
        getOwnerService().delete(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Owner> findAll() {
        return getOwnerService().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findAllByGlobalSearchAndPageable(GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerService().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Owner> findAllByIterable(Iterable<Long> ids) {
        return getOwnerService().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OwnerInfo> findByOwnerCityFormBeanAndGlobalSearchAndPageable(OwnerCityFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerService().findByCityLike(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findByOwnerFirstNameFormBeanAndGlobalSearchAndPageable(OwnerFirstNameFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        return getOwnerService().findByFirstNameLike(formBean, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public Owner findOneByLong(Long id) {
        return getOwnerService().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public Owner findOneForUpdateByLong(Long id) {
        return getOwnerService().findOneForUpdate(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return Owner
     */
    public Owner removeFromPetsByOwnerAndIterable(Owner owner, Iterable<Long> petsToRemove) {
        return getOwnerService().removeFromPets(owner, petsToRemove);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public List<Owner> saveByIterable(Iterable<Owner> entities) {
        return getOwnerService().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Owner
     */
    public Owner saveByOwner(Owner entity) {
        return getOwnerService().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pets
     * @return Owner
     */
    public Owner setPetsByOwnerAndIterable(Owner owner, Iterable<Long> pets) {
        return getOwnerService().setPets(owner, pets);
    }
}
