package org.springframework.roo.petclinic.service.api;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import org.springframework.roo.petclinic.domain.Visit;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.format.EntityResolver;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;

/**
 * = VisitService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Visit.class)
public interface VisitService extends EntityResolver<Visit, Long> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Visit
     */
    public abstract Visit findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     */
    public abstract void delete(Visit visit);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Visit> save(Iterable<Visit> entities);

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
     * @return Visit
     */
    public abstract Visit save(Visit entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Visit
     */
    public abstract Visit findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Visit> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Visit> findAll();

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
    public abstract Page<Visit> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByPet(Pet pet, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByVet(Vet vet, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return Long
     */
    public abstract long countByPet(Pet pet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return Long
     */
    public abstract long countByVet(Vet vet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param visitDate
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByDescriptionAndVisitDate(String description, Date visitDate, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitDate1
     * @param visitDate2
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByVisitDateBetween(Date visitDate1, Date visitDate2, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByDescriptionLike(String description, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @param visitDate
     * @return Long
     */
    public abstract long countByDescriptionAndVisitDate(String description, Date visitDate);

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitDate1
     * @param visitDate2
     * @return Long
     */
    public abstract long countByVisitDateBetween(Date visitDate1, Date visitDate2);

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @return Long
     */
    public abstract long countByDescriptionLike(String description);
}
