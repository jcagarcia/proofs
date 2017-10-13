package io.jcagarcia.roles.division.web.employees;

import io.jcagarcia.roles.division.model.domain.Employee;
import io.jcagarcia.roles.division.service.api.employees.EmployeeService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * = EmployeesController
 */
@RestController("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService service;

    /**
     *
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(produces = Datatables.MEDIA_TYPE, name = "datatables", value = "/dt")
    @ResponseBody
    public ResponseEntity<DatatablesData<Employee>> datatables(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Employee> employees = service.findAll(search, pageable);
        long totalEmployeesCount = employees.getTotalElements();
        if (search != null && StringUtils.hasText(search.getText())) {
            totalEmployeesCount = service.count();
        }
        DatatablesData<Employee> datatablesData = new DatatablesData<Employee>(employees, totalEmployeesCount, draw);
        return  ResponseEntity.ok(datatablesData);
    }

}
