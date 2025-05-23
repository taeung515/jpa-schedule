package com.example.jpascheduler.domain.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    @NotNull(message = "이름을 입력해주세요!")
    @Size(max = 4, message = "이름은 4자까지 입력 가능합니다.")
    private final String username;

    @NotEmpty(message = "이메일을 입력해주세요!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    @NotNull(message = "비밀번호를 입력해주세요!")
    private final String password;

    public UserSignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
