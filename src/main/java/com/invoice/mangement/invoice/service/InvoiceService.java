package com.invoice.mangement.invoice.service;

import org.springframework.stereotype.Service;

public interface InvoiceService {
    int getCompanyMonthlyCost(Long companyUuid);

    int getDepartmentMonthlyCost(Long departmentUuid);

    int getProjectMonthlyCost(Long projectUuid);

    void generateInvoice(Long companyUuid);

    void generateInvoice(Long companyUuid, Long departmentUuid);

    void generateInvoice(Long companyUuid, Long departmentUuid, Long projectUuid);
}
