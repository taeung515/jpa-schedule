package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;

public interface SchduleService {

    ScheduleResponseDto save(ScheduleRequestDto dto);

}
