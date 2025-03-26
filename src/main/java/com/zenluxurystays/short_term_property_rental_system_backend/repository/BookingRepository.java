package com.zenluxurystays.short_term_property_rental_system_backend.repository;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
