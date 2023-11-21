package com.invoice.mangement.department.service;

import com.invoice.mangement.department.model.Department;
import com.invoice.mangement.department.repository.DepartmentRepo;
import com.invoice.mangement.project.model.Project;
import com.invoice.mangement.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    //Inject Department Repo
    DepartmentRepo departmentRepo;
    ProjectService projectService;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo, ProjectService projectService){
        this.departmentRepo = departmentRepo;
        this.projectService = projectService;
    }

    //CRUD
    //Create
    public Department createDepartment(Department department){
        return departmentRepo.save(department);
    }

    //Read
    public Department getDepartment(Long departmentUuid){
        return departmentRepo.findById(departmentUuid).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    //Update
    public Department updateDepartment(Department department){
        return departmentRepo.save(department);
    }

    //Delete
    public void deleteDepartment(Long departmentUuid){
        departmentRepo.deleteById(departmentUuid);
    }

    public int getDepartmentMonthlyCost(Long departmentUuid) {
        List<Project> departmentProjects = projectService.getProjectsByDepartmentUuid(departmentUuid);
        int totalCost = 0;
        for(Project project : departmentProjects){
            totalCost += projectService.getProjectMonthlyCost(project.getUuid());
        }
        return totalCost;
    }

    public List<Department> getDepartmentsByCompanyUuid(Long companyUuid){
        return departmentRepo.findDepartmentsByCompanyUuid(companyUuid);
    }

}
