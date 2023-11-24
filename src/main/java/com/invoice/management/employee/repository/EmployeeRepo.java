package com.invoice.management.employee.repository;

import com.invoice.management.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByProjectUuid(Long projectUuid);
}
