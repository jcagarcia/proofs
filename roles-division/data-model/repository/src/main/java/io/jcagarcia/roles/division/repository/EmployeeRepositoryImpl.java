package io.jcagarcia.roles.division.repository;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.jcagarcia.roles.division.model.domain.QEmployee;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.jcagarcia.roles.division.model.domain.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * = EmployeeRepositoryImpl
 */
@Transactional(readOnly = true)
public class EmployeeRepositoryImpl extends QueryDslRepositorySupportExt<Employee> implements EmployeeRepositoryCustom {

    EmployeeRepositoryImpl() {
        super(Employee.class);
    }


    /**
     *
     * @param globalSearch
     * @param pageable
     * @return
     */
    public Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable) {

        QEmployee employee = QEmployee.employee;

        JPQLQuery<Employee> query = from(employee);

        Path<?>[] paths = new Path<?>[] {};
        applyGlobalSearch(globalSearch, query, paths);

        AttributeMappingBuilder mapping = buildMapper();

        applyPagination(pageable, query, mapping);
        applyOrderById(query);

        return loadPage(query, pageable, employee);
    }

    /**
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return
     */
    public Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {

        QEmployee employee = QEmployee.employee;

        JPQLQuery<Employee> query = from(employee);

        Path<?>[] paths = new Path<?>[] {};
        applyGlobalSearch(globalSearch, query, paths);

        // Also, filter by the provided ids
        query.where(employee.id.in(ids));

        AttributeMappingBuilder mapping = buildMapper();

        applyPagination(pageable, query, mapping);
        applyOrderById(query);

        return loadPage(query, pageable, employee);
    }
}