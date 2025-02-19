package com.zenluxurystays.short_term_property_rental_system_backend.service;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.LoginRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.RegisterRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<Map<String, String>> register(RegisterRequestDto registerRequestDto);

    ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto);
}
