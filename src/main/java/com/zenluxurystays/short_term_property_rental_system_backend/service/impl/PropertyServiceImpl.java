package com.zenluxurystays.short_term_property_rental_system_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.PropertyDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.PropertyImageDto;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.Property;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.PropertyImage;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.ResponseCode;
import com.zenluxurystays.short_term_property_rental_system_backend.exception.PropertyDetailsNotFoundException;
import com.zenluxurystays.short_term_property_rental_system_backend.repository.PropertyRepository;
import com.zenluxurystays.short_term_property_rental_system_backend.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final ObjectMapper mapper;
    private final PropertyRepository propertyRepository;

    @Override
    public ResponseEntity<Map<String, String>> create(PropertyDto propertyDto) {
        try {
            Property property = mapper.convertValue(propertyDto, Property.class);

            for (PropertyImage image : property.getImages()) {
                image.setProperty(property);
            }

            propertyRepository.save(property);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return ResponseEntity.ok(Collections.singletonMap(
                ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage()));
    }

    @Override
    public ResponseEntity<PropertyDto> readById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyDetailsNotFoundException(
                        ResponseCode.PROPERTY_NOT_FOUND.getMessage()
                ));

        return ResponseEntity.ok(
                mapToDto(property)
        );
    }

    private PropertyDto mapToDto(Property property) {
        PropertyDto dto = new PropertyDto();
        dto.setTitle(property.getTitle());
        dto.setDescription(property.getDescription());
        dto.setLocation(property.getLocation());
        dto.setStatus(property.getStatus());
        dto.setAirbnbCalendar(property.getAirbnbCalendar());
        dto.setPricePerDay(property.getPricePerDay());

        if (property.getImages() != null) {
            List<PropertyImageDto> images = property.getImages().stream()
                    .map(propertyImage -> new PropertyImageDto(propertyImage.getId(), propertyImage.getImagePath()))
                    .collect(Collectors.toList());
            dto.setImages(images);
        }
        return dto;
    }
}
