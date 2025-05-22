package com.example.jpascheduler.domain.dto.user;

import lombok.Getter;

@Getter
public class UserSignUpResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    public UserSignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

}
