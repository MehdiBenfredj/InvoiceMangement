package com.invoice.management.project.resource;

import com.invoice.management.project.model.Project;
import com.invoice.management.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectResource {
    //Inject Project Service
    ProjectService projectService;

    @Autowired
    ProjectResource(ProjectService projectService){
        this.projectService = projectService;
    }


    //CRUD
    //Create
    @PostMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    //Read
    @GetMapping("/{projectUuid}")
    public Project getProject(@PathVariable Long projectUuid){
        return projectService.getProject(projectUuid);
    }

    //Update
    @PutMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }


    //Delete
    @DeleteMapping("/{projectUuid}")
    public void deleteProject(@PathVariable Long projectUuid){
        projectService.deleteProject(projectUuid);
    }


}
