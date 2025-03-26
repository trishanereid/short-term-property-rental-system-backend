package com.zenluxurystays.short_term_property_rental_system_backend.service;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.BookingDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BookingService {
    ResponseEntity<Map<String, String>> create(BookingDto bookingDto);
}
