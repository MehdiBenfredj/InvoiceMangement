package com.invoice.mangement.department.repository;

import com.invoice.mangement.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findDepartmentsByCompanyUuid(Long companyUuid);
}
