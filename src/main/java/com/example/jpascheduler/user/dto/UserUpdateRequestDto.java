package com.example.jpascheduler.user.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * 회원정보 수정 요청 데이터.
 * 사용자는 username, email, password 선택하여 수정 요청 할 수 있습니다.
 */
@Getter
public class UserUpdateRequestDto {
    @Size(max = 4, message = "이름은 4자까지 입력 가능합니다.")
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
