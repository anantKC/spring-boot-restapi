package com.springboot.springboot.service;

import com.springboot.springboot.entity.Department;
import com.springboot.springboot.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFound;

    public void deleteMappingById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
