package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.roo.petclinic.domain.Owner;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;
import org.springframework.roo.petclinic.domain.QOwner;
import org.springframework.transaction.annotation.Transactional;

/**
 * = OwnerRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = OwnerRepositoryCustom.class)
@Transactional(readOnly = true)
public class OwnerRepositoryImpl extends QueryDslRepositorySupportExt<Owner> implements OwnerRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    OwnerRepositoryImpl() {
        super(Owner.class);
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
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        Path<?>[] paths = new Path<?>[] { owner.firstName, owner.lastName, owner.address, owner.city, owner.telephone, owner.homePage, owner.email, owner.birthDay, owner.createdDate, owner.createdBy, owner.modifiedDate, owner.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(FIRST_NAME, owner.firstName).map(LAST_NAME, owner.lastName).map(ADDRESS, owner.address).map(CITY, owner.city).map(TELEPHONE, owner.telephone).map(HOME_PAGE, owner.homePage).map(EMAIL, owner.email).map(BIRTH_DAY, owner.birthDay).map(CREATED_DATE, owner.createdDate).map(CREATED_BY, owner.createdBy).map(MODIFIED_DATE, owner.modifiedDate).map(MODIFIED_BY, owner.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        Path<?>[] paths = new Path<?>[] { owner.firstName, owner.lastName, owner.address, owner.city, owner.telephone, owner.homePage, owner.email, owner.birthDay, owner.createdDate, owner.createdBy, owner.modifiedDate, owner.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(owner.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(FIRST_NAME, owner.firstName).map(LAST_NAME, owner.lastName).map(ADDRESS, owner.address).map(CITY, owner.city).map(TELEPHONE, owner.telephone).map(HOME_PAGE, owner.homePage).map(EMAIL, owner.email).map(BIRTH_DAY, owner.birthDay).map(CREATED_DATE, owner.createdDate).map(CREATED_BY, owner.createdBy).map(MODIFIED_DATE, owner.modifiedDate).map(MODIFIED_BY, owner.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Owner> findByFirstNameLike(OwnerFirstNameFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getFirstName() != null) {
                searchCondition.and(owner.firstName.eq(formBean.getFirstName()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { owner.firstName, owner.lastName, owner.address, owner.city, owner.telephone, owner.homePage, owner.email, owner.birthDay, owner.createdDate, owner.createdBy, owner.modifiedDate, owner.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(FIRST_NAME, owner.firstName).map(LAST_NAME, owner.lastName).map(ADDRESS, owner.address).map(CITY, owner.city).map(TELEPHONE, owner.telephone).map(HOME_PAGE, owner.homePage).map(EMAIL, owner.email).map(BIRTH_DAY, owner.birthDay).map(CREATED_DATE, owner.createdDate).map(CREATED_BY, owner.createdBy).map(MODIFIED_DATE, owner.modifiedDate).map(MODIFIED_BY, owner.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OwnerInfo> findByCityLike(OwnerCityFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getCity() != null) {
                searchCondition.and(owner.city.eq(formBean.getCity()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { owner.id, owner.firstName, owner.lastName, owner.city };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, owner.id).map(FIRST_NAME, owner.firstName).map(LAST_NAME, owner.lastName).map(CITY, owner.city);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(OwnerInfo.class, owner.id, owner.firstName, owner.lastName, owner.city));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByFirstNameLike(OwnerFirstNameFormBean formBean) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getFirstName() != null) {
            searchCondition.and(owner.firstName.eq(formBean.getFirstName()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByCityLike(OwnerCityFormBean formBean) {
        QOwner owner = QOwner.owner;
        JPQLQuery<Owner> query = from(owner);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getCity() != null) {
            searchCondition.and(owner.city.eq(formBean.getCity()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }
}
