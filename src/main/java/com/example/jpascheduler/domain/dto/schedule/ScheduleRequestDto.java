package com.example.jpascheduler.domain.dto.schedule;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotEmpty(message = "이메일을 입력해주세요!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    @NotNull(message = "제목을 입력해주세요!")
    @Size(max = 10, message = "제목은 10자까지 입력 가능합니다.")
    private final String title;

    @NotNull(message = "내용을 입력해주세요!")
    private final String contents;

    public ScheduleRequestDto(String email, String title, String contents) {
        this.email = email;
        this.title = title;
        this.contents = contents;
    }
}
