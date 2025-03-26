package com.zenluxurystays.short_term_property_rental_system_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.BookingDto;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.Booking;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.ResponseCode;
import com.zenluxurystays.short_term_property_rental_system_backend.repository.BookingRepository;
import com.zenluxurystays.short_term_property_rental_system_backend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<Map<String, String>> create(BookingDto bookingDto) {
        try {
            repository.save(
                    mapper.convertValue(bookingDto, Booking.class)
            );
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return ResponseEntity.ok(Collections.singletonMap(
                ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage()
        ));
    }
}
