package com.example.jpascheduler.domain.dto.user;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final String username;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    private final String password;

    public UserUpdateRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
