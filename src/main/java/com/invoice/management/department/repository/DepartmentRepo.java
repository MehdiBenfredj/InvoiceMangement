package com.invoice.management.department.repository;

import com.invoice.management.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findDepartmentsByCompanyUuid(Long companyUuid);
}
