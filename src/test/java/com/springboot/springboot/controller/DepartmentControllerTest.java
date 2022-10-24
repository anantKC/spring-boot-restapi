package com.springboot.springboot.controller;

import com.springboot.springboot.entity.Department;
import com.springboot.springboot.error.DepartmentNotFound;
import com.springboot.springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Ram")
                .departmentAddress("Cool")
                .departmentCode("NICE")
                .departmentId(4L)
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("Ram")
                .departmentAddress("Cool")
                .departmentCode("NICE")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "        \n" +
                        "        \"departmentName\":\"Ram\",\n" +
                        "        \"departmentAddress\":\"Cool\",\n" +
                        "        \"departmentCode\":\"NICE\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(4L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/4")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}