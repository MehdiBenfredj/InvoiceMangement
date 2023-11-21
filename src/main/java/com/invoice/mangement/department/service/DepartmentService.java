package com.invoice.mangement.department.service;

import com.invoice.mangement.department.model.Department;
import com.invoice.mangement.department.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    //Inject Department Repo
    DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo){
        this.departmentRepo = departmentRepo;
    }

    //CRUD
    //Create
    public Department createDepartment(Department department){
        return departmentRepo.save(department);
    }

    //Read
    public Department getDepartment(Long departmentUuid){
        return departmentRepo.findById(departmentUuid).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    //Update
    public Department updateDepartment(Department department){
        return departmentRepo.save(department);
    }

    //Delete
    public void deleteDepartment(Long departmentUuid){
        departmentRepo.deleteById(departmentUuid);
    }

}
