package com.invoice.mangement.project.repository;

import com.invoice.mangement.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    List<Project> findProjectsByDepartmentUuid(Long departmentUuid);
}
