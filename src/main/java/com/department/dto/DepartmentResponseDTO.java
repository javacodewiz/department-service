package com.department.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentResponseDTO {

    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
