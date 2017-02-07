package org.springframework.roo.petclinic.service.api;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.VetInfo;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;

/**
 * = VetService
 *
 * TODO Auto-generated class documentation
 *
 */
public interface VetService extends EntityResolver<Vet, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Vet
     */
    public abstract Vet findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     */
    public abstract void delete(Vet vet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Vet> save(Iterable<Vet> entities);

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
     * @return Vet
     */
    public abstract Vet save(Vet entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Vet
     */
    public abstract Vet findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Vet> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Vet> findAll();

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
    public abstract Page<VetInfo> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visitsToAdd
     * @return Vet
     */
    public abstract Vet addToVisits(Vet vet, Iterable<Long> visitsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visitsToRemove
     * @return Vet
     */
    public abstract Vet removeFromVisits(Vet vet, Iterable<Long> visitsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visits
     * @return Vet
     */
    public abstract Vet setVisits(Vet vet, Iterable<Long> visits);
}
