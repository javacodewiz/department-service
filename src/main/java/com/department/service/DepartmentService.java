package com.department.service;

import com.department.dto.DepartmentRequestDTO;
import com.department.dto.DepartmentResponseDTO;
import com.department.model.Department;

import java.util.List;

public interface DepartmentService {


    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO dto);
    public DepartmentResponseDTO getDepartment(String departmentCode);
    public List<DepartmentResponseDTO> getAllDepartments();
    public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO dto);
    public String deleteDepartment(String departmentCode);
    
}
