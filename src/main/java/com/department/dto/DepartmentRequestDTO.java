package com.department.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequestDTO {

    @NotEmpty(message = "Department name is required")
    @Size(min = 2, message = "Department name should have at least 2 characters")
    private String departmentName;

    @NotEmpty(message = "Department description is required")
    @Size(min = 5, message = "Department description should have at least 5 characters")
    private String departmentDescription;

    @NotEmpty(message = "Department code is required")
    @Size(min = 4, message = "Department code should have at least 4 characters")
    private String departmentCode;
}
