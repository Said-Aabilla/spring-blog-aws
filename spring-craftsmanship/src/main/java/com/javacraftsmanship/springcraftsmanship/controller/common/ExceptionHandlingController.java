package com.javacraftsmanship.springcraftsmanship.controller.common;

import com.javacraftsmanship.springcraftsmanship.dto.response.ErrorResponseDto;
import com.javacraftsmanship.springcraftsmanship.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlingController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {

        return ResponseEntity
                .status(HttpServletResponse.SC_NOT_FOUND)
                .body(new ErrorResponseDto(HttpServletResponse.SC_NOT_FOUND,resourceNotFoundException.getMessage()));
    }
}
