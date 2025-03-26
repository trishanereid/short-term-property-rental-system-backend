package com.zenluxurystays.short_term_property_rental_system_backend.controller;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.PropertyDto;
import com.zenluxurystays.short_term_property_rental_system_backend.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/property")
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> create(@RequestBody PropertyDto propertyDto) {
        return propertyService.create(propertyDto);
    }

    @GetMapping("/all")
    public void read() {}

    @GetMapping("/by-id/{id}")
    public ResponseEntity<PropertyDto> readById(@PathVariable Long id) {
        return propertyService.readById(id);
    }

    @PatchMapping("/by-id/{id}")
    public void update() {}

    @DeleteMapping("/by-id/{id}")
    public void delete() {}
}
