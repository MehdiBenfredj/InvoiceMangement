package com.invoice.management.employee.service;

import com.invoice.management.department.model.Department;
import com.invoice.management.department.repository.DepartmentRepo;
import com.invoice.management.employee.model.Employee;
import com.invoice.management.employee.repository.EmployeeRepo;
import com.invoice.management.project.model.Project;
import com.invoice.management.project.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //Inject Employee Repo
    EmployeeRepo employeeRepo;
    ProjectRepo projectRepo;
    DepartmentRepo departmentRepo;

    @Autowired
    EmployeeService(EmployeeRepo employeeRepo,
                    ProjectRepo projectRepo,
                    DepartmentRepo departmentRepo){
        this.employeeRepo = employeeRepo;
        this.projectRepo = projectRepo;
        this.departmentRepo = departmentRepo;
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

    public List<Employee> getEmployeesByDepartmentUuid(Long departmentUuid){
        List<Employee> employees = new ArrayList<>();
        List<Project> projects = projectRepo.findProjectsByDepartmentUuid(departmentUuid);
        for(Project project : projects){
            employees.addAll(employeeRepo.findEmployeesByProjectUuid(project.getUuid()));

        }
        return employees;
    }

    public List<Employee> getEmployeesByCompanyUuid(Long companyUuid){
        List<Department> departments = departmentRepo.findDepartmentsByCompanyUuid(companyUuid);
        List<Project> projects = new ArrayList<>();
        for (Department department : departments){
            projects.addAll(projectRepo.findProjectsByDepartmentUuid(department.getUuid()));
        }
        List<Employee> employees = new ArrayList<>();
        for(Project project : projects){
            employees.addAll(employeeRepo.findEmployeesByProjectUuid(project.getUuid()));

        }
        return employees;
    }

}
