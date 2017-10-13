package io.jcagarcia.roles.division.service.api.employees;

import io.jcagarcia.roles.division.model.domain.Employee;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    /**
     *
     * @param search
     * @param pageable
     * @return
     */
    Page<Employee> findAll(GlobalSearch search, Pageable pageable);

    /**
     *
     * @return
     */
    long count();

}
