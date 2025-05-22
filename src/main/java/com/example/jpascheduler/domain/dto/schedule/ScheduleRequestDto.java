package com.example.jpascheduler.domain.dto.schedule;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String email;

    private final String title;

    private final String contents;

    public ScheduleRequestDto(String email, String title, String contents) {
        this.email = email;
        this.title = title;
        this.contents = contents;
    }
}
