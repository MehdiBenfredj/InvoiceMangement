package com.invoice.management.company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    Long uuid;

    @Column(name = "company_name")
    String companyName;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "uuid=" + uuid +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
