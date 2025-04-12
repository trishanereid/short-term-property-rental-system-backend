package com.zenluxurystays.short_term_property_rental_system_backend.controller;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.BookingDto;
import com.zenluxurystays.short_term_property_rental_system_backend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> create(@RequestBody BookingDto bookingDto){
        return bookingService.create(bookingDto);
    };

    public void read() {

    }

    public void cancel(){

    };
    public void update(){

    };
}
