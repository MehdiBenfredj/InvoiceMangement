package com.invoice.mangement.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    Long uuid;

    @Column(name = "department_uuid")
    Long departmentUuid;

    @Column(name = "project_name")
    String projectName;

    public Project() {
    }

    public Project(Long departmentUuid, String projectName) {
        this.departmentUuid = departmentUuid;
        this.projectName = projectName;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getDepartmentUuid() {
        return departmentUuid;
    }

    public void setDepartmentUuid(Long departmentUuid) {
        this.departmentUuid = departmentUuid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + uuid +
                ", departmentUuid=" + departmentUuid +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
