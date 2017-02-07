package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.petclinic.domain.Pet;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;
import org.springframework.roo.petclinic.domain.QPet;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = PetRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public class PetRepositoryImpl extends QueryDslRepositorySupportExt<Pet> implements PetRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    PetRepositoryImpl() {
        super(Pet.class);
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
    public static final String OWNER = "owner";

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
    public static final String SEND_REMINDERS = "sendReminders";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String WEIGHT = "weight";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String TYPE = "type";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_DATE = "modifiedDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QPet pet = QPet.pet;
        JPQLQuery<Pet> query = from(pet);
        Path<?>[] paths = new Path<?>[] { pet.sendReminders, pet.name, pet.weight, pet.type, pet.owner, pet.createdDate, pet.createdBy, pet.modifiedDate, pet.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(SEND_REMINDERS, pet.sendReminders).map(NAME, pet.name).map(WEIGHT, pet.weight).map(TYPE, pet.type).map(OWNER, pet.owner).map(CREATED_DATE, pet.createdDate).map(CREATED_BY, pet.createdBy).map(MODIFIED_DATE, pet.modifiedDate).map(MODIFIED_BY, pet.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByOwner(Owner owner, GlobalSearch globalSearch, Pageable pageable) {
        QPet pet = QPet.pet;
        JPQLQuery<Pet> query = from(pet);
        Assert.notNull(owner, "owner is required");
        query.where(pet.owner.eq(owner));
        Path<?>[] paths = new Path<?>[] { pet.sendReminders, pet.name, pet.weight, pet.type, pet.owner, pet.createdDate, pet.createdBy, pet.modifiedDate, pet.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(SEND_REMINDERS, pet.sendReminders).map(NAME, pet.name).map(WEIGHT, pet.weight).map(TYPE, pet.type).map(OWNER, pet.owner).map(CREATED_DATE, pet.createdDate).map(CREATED_BY, pet.createdBy).map(MODIFIED_DATE, pet.modifiedDate).map(MODIFIED_BY, pet.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findByNameAndWeight(PetNameAndWeightFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        QPet pet = QPet.pet;
        JPQLQuery<Pet> query = from(pet);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getName() != null) {
                searchCondition.and(pet.name.eq(formBean.getName()));
            }
            if (formBean.getWeight() != null) {
                searchCondition.and(pet.weight.eq(formBean.getWeight()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { pet.sendReminders, pet.name, pet.weight, pet.type, pet.owner, pet.createdDate, pet.createdBy, pet.modifiedDate, pet.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(SEND_REMINDERS, pet.sendReminders).map(NAME, pet.name).map(WEIGHT, pet.weight).map(TYPE, pet.type).map(OWNER, pet.owner).map(CREATED_DATE, pet.createdDate).map(CREATED_BY, pet.createdBy).map(MODIFIED_DATE, pet.modifiedDate).map(MODIFIED_BY, pet.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByNameAndWeight(PetNameAndWeightFormBean formBean) {
        QPet pet = QPet.pet;
        JPQLQuery<Pet> query = from(pet);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getName() != null) {
            searchCondition.and(pet.name.eq(formBean.getName()));
        }
        if (formBean.getWeight() != null) {
            searchCondition.and(pet.weight.eq(formBean.getWeight()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }
}
