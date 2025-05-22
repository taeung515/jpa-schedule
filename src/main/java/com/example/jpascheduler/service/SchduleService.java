package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface SchduleService {

    ScheduleResponseDto save(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAll();
}
