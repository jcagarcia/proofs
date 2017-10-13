package io.jcagarcia.roles.division.service.impl.employees;

import io.jcagarcia.roles.division.model.domain.Employee;
import io.jcagarcia.roles.division.repository.EmployeeRepository;
import io.jcagarcia.roles.division.service.api.employees.EmployeeService;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    /**
     * Obtains all the registered employees using the provided search and the provided
     * pagination.
     *
     * @param search
     * @param pageable
     * @return
     */
    @Override
    public Page<Employee> findAll(GlobalSearch search, Pageable pageable) {
        return repository.findAll(search, pageable);
    }

    /**
     * Counts all the repository
     *
     * @return
     */
    @Override
    public long count() {
        return repository.count();
    }
}
