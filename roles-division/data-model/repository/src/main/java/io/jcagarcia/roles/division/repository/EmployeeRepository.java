package io.jcagarcia.roles.division.repository;
import io.jcagarcia.roles.division.model.domain.Employee;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = EmployeeRepository
 */
@Transactional(readOnly = true)
public interface EmployeeRepository extends DetachableJpaRepository<Employee, Long>, EmployeeRepositoryCustom {
}
