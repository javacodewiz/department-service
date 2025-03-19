package com.department.controller;


import com.department.dto.DepartmentRequestDTO;
import com.department.dto.DepartmentResponseDTO;
import com.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
@Validated
public class DepartmentRestController {


    private DepartmentService service;



    @Operation(summary = "Get department by id",description = "Get department by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Success",content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "404",description = "Not found",content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable("departmentCode") String departmentCode){
        return ResponseEntity.ok(service.getDepartment(departmentCode));
    }


    @Operation(summary = "Get all departments",description = "Get all departments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Success",content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500" ,description = "Internal server error",content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
        return ResponseEntity.ok(service.getAllDepartments());
    }


@Operation(summary = "Add a new department", description = "Add a new department")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = String.class)))
})
@PostMapping
public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO department) {
    return ResponseEntity.ok(service.saveDepartment(department));
}

@Operation(summary = "Update an existing department", description = "Update an existing department")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = DepartmentResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = String.class)))
})
@PutMapping
public ResponseEntity<DepartmentResponseDTO> updateDepartment(@RequestBody DepartmentRequestDTO department) {
    return ResponseEntity.ok(service.updateDepartment(department));
}

@Operation(summary = "Delete a department", description = "Delete a department by department code")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Deleted", content = @Content(schema = @Schema(implementation = String.class))),
        @ApiResponse(responseCode = "404", description = "Not found", content = @Content(schema = @Schema(implementation = String.class)))
})
@DeleteMapping("/{departmentCode}")
public ResponseEntity<String> deleteDepartment(@PathVariable("departmentCode") String departmentCode) {
    return ResponseEntity.ok(service.deleteDepartment(departmentCode));
}



}
