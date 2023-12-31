package com.invoice.management.invoice.resource;

import com.invoice.management.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    //Inject invoice service
    InvoiceService invoiceService;

    @Autowired
    InvoiceResource(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping("/company/{companyUuid}")
    public int getCompanyMonthlyCost(@PathVariable Long companyUuid) {
        return invoiceService.getCompanyMonthlyCost(companyUuid);
    }

    @GetMapping("/department/{departmentUuid}")
    public int getDepartmentMonthlyCost(@PathVariable Long departmentUuid) {
        return invoiceService.getDepartmentMonthlyCost(departmentUuid);
    }

    @GetMapping("/project/{projectUuid}")
    public int getProjectMonthlyCost(@PathVariable Long projectUuid) {
        return invoiceService.getProjectMonthlyCost(projectUuid);
    }

    @GetMapping("/generate/{companyUuid}")
    public void generateInvoice(@PathVariable Long companyUuid) throws FileNotFoundException {
        invoiceService.generateInvoice(companyUuid);
    }






}
