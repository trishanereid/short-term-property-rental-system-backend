package com.zenluxurystays.short_term_property_rental_system_backend.exception.handler;

import com.zenluxurystays.short_term_property_rental_system_backend.exception.ErrorResponse;
import com.zenluxurystays.short_term_property_rental_system_backend.exception.Exception;
import com.zenluxurystays.short_term_property_rental_system_backend.exception.PropertyDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PropertyDetailsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePropertyDetailsNotFoundException(
            PropertyDetailsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .message(e.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    public ResponseEntity<ErrorResponse> handleGlobalExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message(e.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                );
    }
}
