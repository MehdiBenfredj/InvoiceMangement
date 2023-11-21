package com.invoice.mangement.employee.service;

import com.invoice.mangement.employee.model.Employee;
import com.invoice.mangement.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    //Inject Employee Repo
    EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    //CRUD
    //Create
    public Employee createEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //Read
    public Employee getEmployee(Long employeeUuid){
        return employeeRepo.findById(employeeUuid).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    //Update
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    //Delete
    public void deleteEmployee(Long employeeUuid){
        employeeRepo.deleteById(employeeUuid);
    }

    public List<Employee> getEmployeesByProjectUuid(Long projectUuid){
        return employeeRepo.findEmployeesByProjectUuid(projectUuid);
    }
}
