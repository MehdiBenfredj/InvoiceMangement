package com.invoice.mangement.invoice.service;

import com.invoice.mangement.company.service.CompanyService;
import com.invoice.mangement.department.service.DepartmentService;
import com.invoice.mangement.employee.model.Employee;
import com.invoice.mangement.employee.service.EmployeeService;
import com.invoice.mangement.ReportGenerator.ReportGeneratorService;
import com.invoice.mangement.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    //Inject services
    ProjectService projectService;
    EmployeeService employeeService;
    CompanyService companyService;
    DepartmentService departmentService;
    ReportGeneratorService reportGeneratorService;

    @Autowired
    InvoiceServiceImpl(
            ProjectService projectService,
            EmployeeService employeeService,
            CompanyService companyService,
            DepartmentService departmentService,
            ReportGeneratorService reportGeneratorService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
        this.companyService = companyService;
        this.departmentService = departmentService;
        this.reportGeneratorService = reportGeneratorService;
    }

    @Override
    public int getCompanyMonthlyCost(Long companyUuid) {
        return companyService.getCompanyMonthlyCost(companyUuid);
    }

    @Override
    public int getDepartmentMonthlyCost(Long departmentUuid) {
        return departmentService.getDepartmentMonthlyCost(departmentUuid);
    }

    public int getProjectMonthlyCost(Long projectUuid) {
        return projectService.getProjectMonthlyCost(projectUuid);
    }

    @Override
    public void generateInvoice(Long companyUuid) throws FileNotFoundException {
        //Get all employees from company
        List<Employee> employees = employeeService.getEmployeesByCompanyUuid(companyUuid);
        reportGeneratorService.generateReport(employees);
    }

    @Override
    public void generateInvoice(Long companyUuid, Long departmentUuid) {

    }

    @Override
    public void generateInvoice(Long companyUuid, Long departmentUuid, Long projectUuid) {

    }
}
