package com.zenluxurystays.short_term_property_rental_system_backend.dto;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.PropertyImage;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.PropertyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private String title;
    private String description;
    private List<PropertyImage> images;
    private String location;
    private String airbnbCalendar;
    private Double pricePerDay;
    private PropertyStatus status;
}
