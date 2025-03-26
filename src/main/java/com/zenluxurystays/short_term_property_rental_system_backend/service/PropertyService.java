package com.zenluxurystays.short_term_property_rental_system_backend.service;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.PropertyDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PropertyService {
    ResponseEntity<Map<String, String>> create(PropertyDto propertyDto);

    ResponseEntity<PropertyDto> readById(Long id);

}
