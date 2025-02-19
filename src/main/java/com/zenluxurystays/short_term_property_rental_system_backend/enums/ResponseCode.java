package com.zenluxurystays.short_term_property_rental_system_backend.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.tools.Diagnostic;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
    BAD_CREDENTIALS("401", "Invalid username or password"),
    USER_ALREADY_EXIST("409", "User already exists for the given information"),
    SUCCESS("200", "Operation successful");


    private final String code;
    private final String message;
}
