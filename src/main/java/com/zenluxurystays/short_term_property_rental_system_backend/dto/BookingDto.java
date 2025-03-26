package com.zenluxurystays.short_term_property_rental_system_backend.dto;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.Property;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private User user;
    private Property property;
    private Date arriveDate;
    private Date departDate;
    private Double totalPrice;
}
