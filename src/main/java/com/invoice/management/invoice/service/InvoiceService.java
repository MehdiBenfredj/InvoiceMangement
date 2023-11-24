package com.invoice.management.invoice.service;

import java.io.FileNotFoundException;

public interface InvoiceService {
    int getCompanyMonthlyCost(Long companyUuid);

    int getDepartmentMonthlyCost(Long departmentUuid);

    int getProjectMonthlyCost(Long projectUuid);

    void generateInvoice(Long companyUuid) throws FileNotFoundException;

    void generateInvoice(Long companyUuid, Long departmentUuid);

    void generateInvoice(Long companyUuid, Long departmentUuid, Long projectUuid) throws FileNotFoundException;
}
