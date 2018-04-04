package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.transaction.annotation.Transactional;

/**
 * = VisitRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Visit.class, finders = { @RooFinder(value = "findByDescriptionAndVisitDate", returnType = Visit.class), @RooFinder(value = "findByVisitDateBetween", returnType = Visit.class), @RooFinder(value = "findByDescriptionLike", returnType = Visit.class) })
@Transactional(readOnly = true)
public interface VisitRepository extends DetachableJpaRepository<Visit, Long>, VisitRepositoryCustom {

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
     * @param pet
     * @return Long
     */
    public abstract long countByPet(Pet pet);

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
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByVisitDateBetween(Date visitDate1, Date visitDate2, Pageable pageable);

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
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByDescriptionLike(String description, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param description
     * @return Long
     */
    public abstract long countByDescriptionLike(String description);
}
