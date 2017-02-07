package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.petclinic.domain.Visit;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.QVisit;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = VisitRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class VisitRepositoryImpl extends QueryDslRepositorySupportExt<Visit> implements VisitRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    VisitRepositoryImpl() {
        super(Visit.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String VET = "vet";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_BY = "modifiedBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_DATE = "createdDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String VISIT_DATE = "visitDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PET = "pet";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_DATE = "modifiedDate";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Visit> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QVisit visit = QVisit.visit;
        JPQLQuery<Visit> query = from(visit);
        Path<?>[] paths = new Path<?>[] { visit.description, visit.visitDate, visit.pet, visit.vet, visit.createdDate, visit.createdBy, visit.modifiedDate, visit.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, visit.description).map(VISIT_DATE, visit.visitDate).map(PET, visit.pet).map(VET, visit.vet).map(CREATED_DATE, visit.createdDate).map(CREATED_BY, visit.createdBy).map(MODIFIED_DATE, visit.modifiedDate).map(MODIFIED_BY, visit.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, visit);
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
        QVisit visit = QVisit.visit;
        JPQLQuery<Visit> query = from(visit);
        Assert.notNull(pet, "pet is required");
        query.where(visit.pet.eq(pet));
        Path<?>[] paths = new Path<?>[] { visit.description, visit.visitDate, visit.pet, visit.vet, visit.createdDate, visit.createdBy, visit.modifiedDate, visit.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, visit.description).map(VISIT_DATE, visit.visitDate).map(PET, visit.pet).map(VET, visit.vet).map(CREATED_DATE, visit.createdDate).map(CREATED_BY, visit.createdBy).map(MODIFIED_DATE, visit.modifiedDate).map(MODIFIED_BY, visit.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, visit);
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
        QVisit visit = QVisit.visit;
        JPQLQuery<Visit> query = from(visit);
        Assert.notNull(vet, "vet is required");
        query.where(visit.vet.eq(vet));
        Path<?>[] paths = new Path<?>[] { visit.description, visit.visitDate, visit.pet, visit.vet, visit.createdDate, visit.createdBy, visit.modifiedDate, visit.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, visit.description).map(VISIT_DATE, visit.visitDate).map(PET, visit.pet).map(VET, visit.vet).map(CREATED_DATE, visit.createdDate).map(CREATED_BY, visit.createdBy).map(MODIFIED_DATE, visit.modifiedDate).map(MODIFIED_BY, visit.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, visit);
    }
}
