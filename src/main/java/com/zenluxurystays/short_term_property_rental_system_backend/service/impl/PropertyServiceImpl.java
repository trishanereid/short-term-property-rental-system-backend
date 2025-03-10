package com.zenluxurystays.short_term_property_rental_system_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.PropertyDto;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.Property;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.ResponseCode;
import com.zenluxurystays.short_term_property_rental_system_backend.repository.PropertyRepository;
import com.zenluxurystays.short_term_property_rental_system_backend.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final ObjectMapper mapper;
    private final PropertyRepository propertyRepository;

    @Override
    public ResponseEntity<Map<String, String>> create(PropertyDto propertyDto) {
        try {
            propertyRepository.save(
                    mapper.convertValue(propertyDto, Property.class)
            );
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return ResponseEntity.ok(Collections.singletonMap(
                ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage()));
    }
}
