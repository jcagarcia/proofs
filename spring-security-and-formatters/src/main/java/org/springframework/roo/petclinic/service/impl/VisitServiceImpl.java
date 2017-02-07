package org.springframework.roo.petclinic.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.repository.VisitRepository;
import org.springframework.roo.petclinic.service.api.VisitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = VisitServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class VisitServiceImpl implements VisitService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VisitRepository visitRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param visitRepository
     */
    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository) {
        setVisitRepository(visitRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VisitRepository
     */
    public VisitRepository getVisitRepository() {
        return visitRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitRepository
     */
    public void setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     */
    @Transactional
    public void delete(Visit visit) {
        // Clear bidirectional many-to-one child relationship with Vet
        if (visit.getVet() != null) {
            visit.getVet().getVisits().remove(visit);
        }
        // Clear bidirectional many-to-one child relationship with Pet
        if (visit.getPet() != null) {
            visit.getPet().getVisits().remove(visit);
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
    public List<Visit> save(Iterable<Visit> entities) {
        return getVisitRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
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
    public Visit save(Visit entity) {
        return getVisitRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Visit
     */
    public Visit findOne(Long id) {
        return getVisitRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Visit
     */
    public Visit findOneForUpdate(Long id) {
        return getVisitRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Visit> findAll(Iterable<Long> ids) {
        return getVisitRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Visit> findAll() {
        return getVisitRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getVisitRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> findByPet(Pet pet, GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findByPet(pet, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> findByVet(Vet vet, GlobalSearch globalSearch, Pageable pageable) {
        return getVisitRepository().findByVet(vet, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return Long
     */
    public long countByPet(Pet pet) {
        return getVisitRepository().countByPet(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return Long
     */
    public long countByVet(Vet vet) {
        return getVisitRepository().countByVet(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param visitDate
     * @param pageable
     * @return Page
     */
    public Page<Visit> findByDescriptionAndVisitDate(String description, Date visitDate, Pageable pageable) {
        return getVisitRepository().findByDescriptionAndVisitDate(description, visitDate, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitDate1
     * @param visitDate2
     * @param pageable
     * @return Page
     */
    public Page<Visit> findByVisitDateBetween(Date visitDate1, Date visitDate2, Pageable pageable) {
        return getVisitRepository().findByVisitDateBetween(visitDate1, visitDate2, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param pageable
     * @return Page
     */
    public Page<Visit> findByDescriptionLike(String description, Pageable pageable) {
        return getVisitRepository().findByDescriptionLike(description, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param visitDate
     * @return Long
     */
    public long countByDescriptionAndVisitDate(String description, Date visitDate) {
        return getVisitRepository().countByDescriptionAndVisitDate(description, visitDate);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitDate1
     * @param visitDate2
     * @return Long
     */
    public long countByVisitDateBetween(Date visitDate1, Date visitDate2) {
        return getVisitRepository().countByVisitDateBetween(visitDate1, visitDate2);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @return Long
     */
    public long countByDescriptionLike(String description) {
        return getVisitRepository().countByDescriptionLike(description);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Visit> getEntityType() {
        return Visit.class;
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
