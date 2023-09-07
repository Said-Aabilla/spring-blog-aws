package com.javacraftsmanship.springcraftsmanship.controller.common;

import com.javacraftsmanship.springcraftsmanship.dto.response.ErrorResponseDto;
import com.javacraftsmanship.springcraftsmanship.exception.BlogAPIException;
import com.javacraftsmanship.springcraftsmanship.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlingController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {

        return ResponseEntity
                .status(HttpServletResponse.SC_NOT_FOUND)
                .body(new ErrorResponseDto(HttpServletResponse.SC_NOT_FOUND, resourceNotFoundException.getMessage()));
    }

    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<ErrorResponseDto> handleBlogAPIException(BlogAPIException exception) {
        return ResponseEntity
                .status(HttpServletResponse.SC_BAD_REQUEST)
                .body(new ErrorResponseDto(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception) {
        return ResponseEntity
                .status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, exception.getMessage()));
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponseDto> handleAccessDeniedException(AccessDeniedException exception) {
        return ResponseEntity
                .status(HttpServletResponse.SC_UNAUTHORIZED)
                .body(new ErrorResponseDto(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                        WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
