package com.zenluxurystays.short_term_property_rental_system_backend.dto;

import com.zenluxurystays.short_term_property_rental_system_backend.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private UserRole role;
}
