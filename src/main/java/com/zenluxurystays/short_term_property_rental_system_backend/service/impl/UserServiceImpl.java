package com.zenluxurystays.short_term_property_rental_system_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenluxurystays.short_term_property_rental_system_backend.constants.ApplicationConstants;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.LoginRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.request.RegisterRequestDto;
import com.zenluxurystays.short_term_property_rental_system_backend.dto.response.LoginResponseDto;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.Authority;
import com.zenluxurystays.short_term_property_rental_system_backend.entity.User;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.ResponseCode;
import com.zenluxurystays.short_term_property_rental_system_backend.enums.UserRole;
import com.zenluxurystays.short_term_property_rental_system_backend.exception.AlreadyExistsException;
import com.zenluxurystays.short_term_property_rental_system_backend.repository.UserRepository;
import com.zenluxurystays.short_term_property_rental_system_backend.service.UserService;
import com.zenluxurystays.short_term_property_rental_system_backend.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<Map<String, String>> register(RegisterRequestDto registerRequestDto) {
        if (userRepository.findByEmail(registerRequestDto.email()).isPresent()) {
            throw new AlreadyExistsException(ResponseCode.USER_ALREADY_EXIST.getMessage());
        }

        User user = mapper.convertValue(registerRequestDto, User.class);
        user.setPassword(passwordEncoder.encode(registerRequestDto.password()));
        user.setRole(UserRole.USER);
        user.setAuthorities(Collections.singleton(new Authority("ROLE_USER", user)));

        userRepository.save(user);
        return ResponseEntity.ok(Collections.singletonMap(
                ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage()));
    }

    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(
                loginRequestDto.email(), loginRequestDto.password());
        Authentication authResponse;

        try {
            authResponse = authenticationManager.authenticate(authentication);
        } catch (Exception e) {
            throw new BadCredentialsException(ResponseCode.BAD_CREDENTIALS.getMessage(), e);
        }

        if (authResponse == null || !authResponse.isAuthenticated()) {
            throw new BadCredentialsException(ResponseCode.BAD_CREDENTIALS.getMessage());
        }

        String generatedToken = "Bearer " + jwtTokenProvider.generateToken(authResponse);

        return ResponseEntity.status(HttpStatus.OK)
                .header(ApplicationConstants.JWT_HEADER, generatedToken)
                .body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), generatedToken));
    }
}
