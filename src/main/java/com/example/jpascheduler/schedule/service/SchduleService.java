package com.example.jpascheduler.schedule.service;

import com.example.jpascheduler.schedule.dto.ScheduleRequestDto;
import com.example.jpascheduler.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface SchduleService {

    ScheduleResponseDto save(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    ScheduleResponseDto update(Long id, ScheduleRequestDto requestDto);

    void delete(Long id);
}
