package com.zenluxurystays.short_term_property_rental_system_backend.controller;

import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.LoginRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.RegisterRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.response.LoginResponseDto;
import com.zenluxurystays.short_term_property_rental_system_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return userService.register(registerRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }
}
