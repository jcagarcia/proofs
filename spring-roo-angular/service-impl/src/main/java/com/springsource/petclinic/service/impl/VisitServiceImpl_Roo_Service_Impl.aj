// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.petclinic.service.impl;

import com.springsource.petclinic.model.Vet;
import com.springsource.petclinic.model.Visit;
import com.springsource.petclinic.repository.VisitRepository;
import com.springsource.petclinic.service.impl.VisitServiceImpl;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect VisitServiceImpl_Roo_Service_Impl {
    
    declare @type: VisitServiceImpl: @Service;
    
    declare @type: VisitServiceImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    private VisitRepository VisitServiceImpl.visitRepository;
    
    /**
     * TODO Auto-generated constructor documentation
     * 
     * @param visitRepository
     */
    @Autowired
    public VisitServiceImpl.new(VisitRepository visitRepository) {
        setVisitRepository(visitRepository);
    }

    /**
     * TODO Auto-generated method documentation
     * 
     * @return VisitRepository
     */
    public VisitRepository VisitServiceImpl.getVisitRepository() {
        return visitRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param visitRepository
     */
    public void VisitServiceImpl.setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param visit
     */
    @Transactional
    public void VisitServiceImpl.delete(Visit visit) {
        // Clear bidirectional many-to-one child relationship with Vet
        if (visit.getVet() != null) {
            visit.getVet().getVisits().remove(visit);
        }
        
        getVisitRepository().delete(visit);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    @Transactional
    public List<Visit> VisitServiceImpl.save(Iterable<Visit> entities) {
        return getVisitRepository().save(entities);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    @Transactional
    public void VisitServiceImpl.delete(Iterable<Long> ids) {
        List<Visit> toDelete = getVisitRepository().findAll(ids);
        getVisitRepository().deleteInBatch(toDelete);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Visit
     */
    @Transactional
    public Visit VisitServiceImpl.save(Visit entity) {
        return getVisitRepository().save(entity);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Visit
     */
    public Visit VisitServiceImpl.findOne(Long id) {
        return getVisitRepository().findOne(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Visit
     */
    public Visit VisitServiceImpl.findOneForUpdate(Long id) {
        return getVisitRepository().findOneDetached(id);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public List<Visit> VisitServiceImpl.findAll(Iterable<Long> ids) {
        return getVisitRepository().findAll(ids);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public List<Visit> VisitServiceImpl.findAll() {
        return getVisitRepository().findAll();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public long VisitServiceImpl.count() {
        return getVisitRepository().count();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> VisitServiceImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findAll(globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> VisitServiceImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> VisitServiceImpl.findByVet(Vet vet, GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findByVet(vet, globalSearch, pageable);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     * @return Long
     */
    public long VisitServiceImpl.countByVet(Vet vet) {
        return getVisitRepository().countByVet(vet);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Visit> VisitServiceImpl.getEntityType() {
        return Visit.class;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<Long> VisitServiceImpl.getIdType() {
        return Long.class;
    }
    
}
