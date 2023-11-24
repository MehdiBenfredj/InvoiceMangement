package com.invoice.management.company.resource;

import com.invoice.management.company.model.Company;
import com.invoice.management.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyResource {
    //Inject CompanyService
    CompanyService companyService;

    @Autowired
    CompanyResource(CompanyService companyService){
        this.companyService = companyService;
    }

    //CRUD
    //Create
    @PostMapping(
            value = "/{companyName}",
            produces = "application/json",
            consumes = "application/json"
    )
    public Company createCompany(@PathVariable String companyName){
        return companyService.createCompany(companyName);
    }
    //Read
    @GetMapping("/{companyUuid}")
    public Company getCompany(@PathVariable Long companyUuid){
        return companyService.getCompany(companyUuid);
    }
    //Update
    @PutMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    //Delete
    @DeleteMapping("/{companyUuid}")
    public void deleteCompany(@PathVariable Long companyUuid){
        companyService.deleteCompany(companyUuid);
    }


}
