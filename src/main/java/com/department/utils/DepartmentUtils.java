package com.department.utils;

import com.department.dto.DepartmentRequestDTO;
import com.department.dto.DepartmentResponseDTO;
import com.department.model.Department;

public class DepartmentUtils {


    public static Department mapToModel(DepartmentRequestDTO department)
    {
        return Department.builder()
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();
    }


    public static DepartmentResponseDTO mapToDto(Department department)
    {
        return DepartmentResponseDTO.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();
    }
}
