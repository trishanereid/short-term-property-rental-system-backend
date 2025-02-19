package com.zenluxurystays.short_term_property_rental_system_backend.repository;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
