package com.department.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorMessageDTO {

    private String apiPath;
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
