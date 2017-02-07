package org.springframework.roo.petclinic.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.VetInfo;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.repository.VetRepository;
import org.springframework.roo.petclinic.service.api.VetService;
import org.springframework.roo.petclinic.service.api.VisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = VetServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class VetServiceImpl implements VetService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VisitService visitService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VetRepository vetRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param vetRepository
     * @param visitService
     */
    @Autowired
    public VetServiceImpl(VetRepository vetRepository, @Lazy VisitService visitService) {
        setVetRepository(vetRepository);
        setVisitService(visitService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VetRepository
     */
    public VetRepository getVetRepository() {
        return vetRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vetRepository
     */
    public void setVetRepository(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
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
     * @param vet
     * @param visitsToAdd
     * @return Vet
     */
    @Transactional
    public Vet addToVisits(Vet vet, Iterable<Long> visitsToAdd) {
        List<Visit> visits = getVisitService().findAll(visitsToAdd);
        vet.addToVisits(visits);
        return getVetRepository().save(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visitsToRemove
     * @return Vet
     */
    @Transactional
    public Vet removeFromVisits(Vet vet, Iterable<Long> visitsToRemove) {
        List<Visit> visits = getVisitService().findAll(visitsToRemove);
        vet.removeFromVisits(visits);
        return getVetRepository().save(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visits
     * @return Vet
     */
    @Transactional
    public Vet setVisits(Vet vet, Iterable<Long> visits) {
        List<Visit> items = getVisitService().findAll(visits);
        Set<Visit> currents = vet.getVisits();
        Set<Visit> toRemove = new HashSet<Visit>();
        for (Iterator<Visit> iterator = currents.iterator(); iterator.hasNext(); ) {
            Visit nextVisit = iterator.next();
            if (items.contains(nextVisit)) {
                items.remove(nextVisit);
            } else {
                toRemove.add(nextVisit);
            }
        }
        vet.removeFromVisits(toRemove);
        vet.addToVisits(items);
        return getVetRepository().save(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     */
    @Transactional
    public void delete(Vet vet) {
        // Clear bidirectional one-to-many parent relationship with Visit
        for (Visit item : vet.getVisits()) {
            item.setVet(null);
        }
        getVetRepository().delete(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Vet> save(Iterable<Vet> entities) {
        return getVetRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Vet> toDelete = getVetRepository().findAll(ids);
        getVetRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Vet
     */
    @Transactional
    public Vet save(Vet entity) {
        return getVetRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Vet
     */
    public Vet findOne(Long id) {
        return getVetRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Vet
     */
    public Vet findOneForUpdate(Long id) {
        return getVetRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Vet> findAll(Iterable<Long> ids) {
        return getVetRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Vet> findAll() {
        return getVetRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getVetRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<VetInfo> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getVetRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Vet> getEntityType() {
        return Vet.class;
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
