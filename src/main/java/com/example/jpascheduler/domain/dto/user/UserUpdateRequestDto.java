package com.example.jpascheduler.domain.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateRequestDto {

    private final String username;

    private final String email;

    private final String password;

    public UserUpdateRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
