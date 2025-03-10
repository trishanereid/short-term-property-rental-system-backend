package com.zenluxurystays.short_term_property_rental_system_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long userId;
    private Long propertyId;
    private Date arriveDate;
    private Date departDate;
    private Double totalPrice;
}
