package com.springboot.springboot.service;

import com.springboot.springboot.entity.Department;
import com.springboot.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Anant")
                        .departmentAddress("HOT")
                        .departmentCode("BE")
                        .departmentId(3L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Anant"))
                .thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "Anant";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }

}