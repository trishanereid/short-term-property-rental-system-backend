package com.zenluxurystays.short_term_property_rental_system_backend.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
