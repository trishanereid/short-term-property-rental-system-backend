package com.zenluxurystays.short_term_property_rental_system_backend.repository;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long > {
}
