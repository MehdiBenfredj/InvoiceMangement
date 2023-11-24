package com.invoice.management.department.model;


import jakarta.persistence.*;


@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    Long uuid;

    @Column(name = "company_uuid")
    Long companyUuid;

    @Column(name = "department_name")
    String departmentName;

    public Department() {
    }

    public Department(Long companyUuid, String departmentName) {
        this.companyUuid = companyUuid;
        this.departmentName = departmentName;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(Long companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "uuid=" + uuid +
                ", companyUuid=" + companyUuid +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
