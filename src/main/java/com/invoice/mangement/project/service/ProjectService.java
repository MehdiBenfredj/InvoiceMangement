package com.invoice.mangement.project.service;

import com.invoice.mangement.project.model.Project;
import com.invoice.mangement.project.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    //Inject Project Repo
    ProjectRepo projectRepo;

    @Autowired
    ProjectService(ProjectRepo projectRepo){
        this.projectRepo = projectRepo;
    }

    //CRUD
    //Create
    public Project createProject(Project project){
        return projectRepo.save(project);
    }

    //Read
    public Project getProject(Long projectUuid){
        return projectRepo.findById(projectUuid).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    //Update
    public  Project updateProject(Project project){
        return projectRepo.save(project);
    }

    //Delete
    public void deleteProject(Long projectUuid){
        projectRepo.deleteById(projectUuid);
    }
}
