package com.invoice.mangement.department.resource;

import com.invoice.mangement.department.model.Department;
import com.invoice.mangement.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentResource {
    //Inject Department Service
    DepartmentService departmentService;

    @Autowired
    DepartmentResource(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    //CRUD
    //Create
    @PostMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    //Read
    @GetMapping("/{departmentUuid}")
    public Department getDepartment(@PathVariable Long departmentUuid){
        return departmentService.getDepartment(departmentUuid);
    }

    //Update
    @PutMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    //Delete
    @DeleteMapping("/{departmentUuid}")
    public void deleteDepartment(@PathVariable Long departmentUuid){
        departmentService.deleteDepartment(departmentUuid);
    }
}
