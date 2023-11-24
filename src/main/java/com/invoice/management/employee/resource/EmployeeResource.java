package com.invoice.management.employee.resource;

import com.invoice.management.employee.model.Employee;
import com.invoice.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    //Inject Employee Service
    EmployeeService employeeService;

    @Autowired
    EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //CRUD
    //Create
    @PostMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    //Read
    @GetMapping("/{employeeUuid}")
    public Employee getEmployee(@PathVariable Long employeeUuid){
        return employeeService.getEmployee(employeeUuid);
    }

    //Update
    @PutMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    //Delete
    @DeleteMapping("/{employeeUuid}")
    public void deleteEmployee(@PathVariable Long employeeUuid){
        employeeService.deleteEmployee(employeeUuid);
    }
}
