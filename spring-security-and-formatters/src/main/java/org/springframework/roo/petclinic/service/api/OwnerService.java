package org.springframework.roo.petclinic.service.api;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = OwnerService
 *
 * TODO Auto-generated class documentation
 *
 */
public interface OwnerService extends EntityResolver<Owner, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public abstract Owner findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     */
    public abstract void delete(Owner owner);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Owner> save(Iterable<Owner> entities);

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
     * @return Owner
     */
    public abstract Owner save(Owner entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    public abstract Owner findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Owner> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Owner> findAll();

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
    public abstract Page<Owner> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToAdd
     * @return Owner
     */
    public abstract Owner addToPets(Owner owner, Iterable<Long> petsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return Owner
     */
    public abstract Owner removeFromPets(Owner owner, Iterable<Long> petsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pets
     * @return Owner
     */
    public abstract Owner setPets(Owner owner, Iterable<Long> pets);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Owner> findByFirstNameLike(OwnerFirstNameFormBean formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OwnerInfo> findByCityLike(OwnerCityFormBean formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByFirstNameLike(OwnerFirstNameFormBean formBean);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByCityLike(OwnerCityFormBean formBean);
}
