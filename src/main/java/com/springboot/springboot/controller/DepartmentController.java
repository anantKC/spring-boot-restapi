package com.springboot.springboot.controller;

import com.springboot.springboot.entity.Department;
import com.springboot.springboot.error.DepartmentNotFound;
import com.springboot.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteMappingById(@PathVariable("id") Long departmentId){
        departmentService.deleteMappingById(departmentId);
        return "Deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable ("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable ("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
