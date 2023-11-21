package com.invoice.mangement.company.service;

import com.invoice.mangement.company.model.Company;
import com.invoice.mangement.company.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    //Inject CompanyRepo
    CompanyRepo companyRepo;

    @Autowired
    public CompanyService(CompanyRepo companyRepo){
        this.companyRepo = companyRepo;
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
}
