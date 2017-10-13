package io.jcagarcia.roles.division.repository;
import io.jcagarcia.roles.division.model.domain.Employee;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * = EmployeeRepositoryCustom
 */
public interface EmployeeRepositoryCustom {

    /**
     *
     * @param globalSearch
     * @param pageable
     * @return
     */
    Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return
     */
    Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
