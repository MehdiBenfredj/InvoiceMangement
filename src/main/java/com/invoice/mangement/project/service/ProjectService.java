package com.invoice.mangement.project.service;

import com.invoice.mangement.employee.model.Employee;
import com.invoice.mangement.employee.service.EmployeeService;
import com.invoice.mangement.project.model.Project;
import com.invoice.mangement.project.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    //Inject Project Repo
    ProjectRepo projectRepo;
    EmployeeService employeeService;

    @Autowired
    ProjectService(ProjectRepo projectRepo, EmployeeService employeeService){
        this.projectRepo = projectRepo;
        this.employeeService = employeeService;
    }

    //CRUD
    //Create
    public Project createProject(Project project){
        return projectRepo.save(project);
    }

    //Read
    public Project getProject(Long projectUuid){
        return projectRepo.findById(projectUuid).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    //Update
    public  Project updateProject(Project project){
        return projectRepo.save(project);
    }

    //Delete
    public void deleteProject(Long projectUuid){
        projectRepo.deleteById(projectUuid);
    }

    public int getProjectMonthlyCost(Long ProjectUuid) {
        List<Employee> projectEmployees = employeeService.getEmployeesByProjectUuid(ProjectUuid);
        int totalCost = 0;
        for(Employee employee : projectEmployees){
            totalCost += employee.getSalary();
        }
        return totalCost;
    }

    public List<Project> getProjectsByDepartmentUuid(Long departmentUuid){
        return projectRepo.findProjectsByDepartmentUuid(departmentUuid);
    }
}
