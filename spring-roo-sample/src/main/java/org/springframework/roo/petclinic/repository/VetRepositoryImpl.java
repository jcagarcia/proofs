package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.roo.petclinic.domain.Vet;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.QVet;
import org.springframework.roo.petclinic.domain.VetInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * = VetRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = VetRepositoryCustom.class)
@Transactional(readOnly = true)
public class VetRepositoryImpl extends QueryDslRepositorySupportExt<Vet> implements VetRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    VetRepositoryImpl() {
        super(Vet.class);
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
    public static final String TELEPHONE = "telephone";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_BY = "modifiedBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_DATE = "createdDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SPECIALTY = "specialty";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String LAST_NAME = "lastName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMAIL = "email";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FIRST_NAME = "firstName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_DATE = "modifiedDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BIRTH_DAY = "birthDay";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CITY = "city";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String HOME_PAGE = "homePage";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ADDRESS = "address";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ID = "id";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMPLOYED_SINCE = "employedSince";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<VetInfo> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QVet vet = QVet.vet;
        JPQLQuery<Vet> query = from(vet);
        Path<?>[] paths = new Path<?>[] { vet.id, vet.firstName, vet.lastName, vet.specialty };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, vet.id).map(FIRST_NAME, vet.firstName).map(LAST_NAME, vet.lastName).map(SPECIALTY, vet.specialty);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(VetInfo.class, vet.id, vet.firstName, vet.lastName, vet.specialty));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<VetInfo> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QVet vet = QVet.vet;
        JPQLQuery<Vet> query = from(vet);
        Path<?>[] paths = new Path<?>[] { vet.id, vet.firstName, vet.lastName, vet.specialty };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(vet.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(ID, vet.id).map(FIRST_NAME, vet.firstName).map(LAST_NAME, vet.lastName).map(SPECIALTY, vet.specialty);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(VetInfo.class, vet.id, vet.firstName, vet.lastName, vet.specialty));
    }
}
