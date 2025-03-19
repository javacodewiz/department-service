package com.department.service.impl;

import com.department.dto.DepartmentRequestDTO;
import com.department.dto.DepartmentResponseDTO;
import com.department.exception.ResourceAlreadyExistsBussinessException;
import com.department.exception.ResourceNotFoundBussinessException;
import com.department.model.Department;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;
import com.department.utils.DepartmentUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository repository;


    @Override
    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO dto) {
        log.info("Inside saveDepartment method");
        Optional<Department> od = repository.getByDepartmentCode(dto.getDepartmentCode());
        if(od.isPresent())
        {
            log.info("Inside Exception");
            throw  new ResourceAlreadyExistsBussinessException("Department already exists with this department code "+dto.getDepartmentCode());
        }else {
            Department department = DepartmentUtils.mapToModel(dto);
            Department save = repository.save(department);
            log.info("Record saved");
            return DepartmentUtils.mapToDto(save);
        }
    }



    @Override
    public DepartmentResponseDTO getDepartment(String departmentCode) {
        log.info("Inside getDepartment method");
        Department department = repository.getByDepartmentCode(departmentCode).orElseThrow(()-> new ResourceNotFoundBussinessException("Department not found"));
        log.info("Record found");
        return DepartmentUtils.mapToDto(department);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        log.info("Inside getAllDepartments method");
        List<Department> departments = repository.findAll();
        log.info("Fetched all records successfully");
        return departments.stream().map(DepartmentUtils::mapToDto).toList();
    }

    @Override
    public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO dto) {
        log.info("Inside updateDepartment method");
        Department department = repository.getByDepartmentCode(dto.getDepartmentCode()).orElseThrow(()->new ResourceNotFoundBussinessException("Department not found"));
        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentDescription(dto.getDepartmentDescription());
        log.info("Record updated");
        return DepartmentUtils.mapToDto(repository.save(department));
    }

    @Override
    public String deleteDepartment(String departmentCode) {
        log.info("Inside deleteDepartment method");
        Department department = repository.getByDepartmentCode(departmentCode).orElseThrow(()->new ResourceNotFoundBussinessException("Department not found"));
        repository.delete(department);
        log.info("Deleting record");
        return "Department deleted successfully";
    }
}
