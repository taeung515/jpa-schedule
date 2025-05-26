package com.example.jpascheduler.schedule.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * 일정 수정 요청 데이터.
 * 사용자는 email, title, contents 선택하여 수정 요청 할 수 있습니다.
 */
@Getter
public class ScheduleUpdateRequestDto {

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "올바른 이메일 형식이 아닙니다.")
    private final String email;

    @Size(max = 10, message = "제목은 10자까지 입력 가능합니다.")
    private final String title;

    private final String contents;

    public ScheduleUpdateRequestDto(String email, String title, String contents) {
        this.email = email;
        this.title = title;
        this.contents = contents;
    }
}
