package com.invoice.management.company.service;

import com.invoice.management.company.model.Company;
import com.invoice.management.company.repository.CompanyRepo;
import com.invoice.management.department.model.Department;
import com.invoice.management.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    //Inject CompanyRepo
    CompanyRepo companyRepo;
    DepartmentService departmentService;

    @Autowired
    public CompanyService(CompanyRepo companyRepo, DepartmentService departmentService) {
        this.companyRepo = companyRepo;
        this.departmentService = departmentService;
    }

    //CRUD
    //Create
    public Company createCompany(String name){
        return companyRepo.save(new Company(name));
    }
    //Read
    public Company getCompany(Long companyUuid){
        return companyRepo.findById(companyUuid).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    //Update
    public Company updateCompany(Company company){
        return companyRepo.save(company);
    }

    //Delete
    public void deleteCompany(Long companyUuid){
        companyRepo.deleteById(companyUuid);
    }

    public int getCompanyMonthlyCost(Long companyUuid) {
        List<Department> companyDepartments = departmentService.getDepartmentsByCompanyUuid(companyUuid);
        int totalCost = 0;
        for(Department department : companyDepartments){
            totalCost += departmentService.getDepartmentMonthlyCost(department.getUuid());
        }
        return totalCost;
    }
}
