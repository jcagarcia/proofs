// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.petclinic.service.api;

import com.springsource.petclinic.model.Vet;
import com.springsource.petclinic.service.api.VetService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

privileged aspect VetService_Roo_Service {
    
    declare parents: VetService extends EntityResolver<Vet, Long>;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Vet
     */
    public abstract Vet VetService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     */
    public abstract void VetService.delete(Vet vet);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Vet> VetService.save(Iterable<Vet> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void VetService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Vet
     */
    public abstract Vet VetService.save(Vet entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Vet
     */
    public abstract Vet VetService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Vet> VetService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Vet> VetService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long VetService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Vet> VetService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Vet> VetService.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     * @param visitsToAdd
     * @return Vet
     */
    public abstract Vet VetService.addToVisits(Vet vet, Iterable<Long> visitsToAdd);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     * @param visitsToRemove
     * @return Vet
     */
    public abstract Vet VetService.removeFromVisits(Vet vet, Iterable<Long> visitsToRemove);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     * @param visits
     * @return Vet
     */
    public abstract Vet VetService.setVisits(Vet vet, Iterable<Long> visits);
    
}
