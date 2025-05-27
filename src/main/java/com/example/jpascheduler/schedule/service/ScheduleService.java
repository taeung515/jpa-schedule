package com.example.jpascheduler.schedule.service;

import com.example.jpascheduler.schedule.dto.ScheduleRequestDto;
import com.example.jpascheduler.schedule.dto.ScheduleResponseDto;
import com.example.jpascheduler.schedule.dto.ScheduleUpdateRequestDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto save(ScheduleRequestDto dto);

    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    ScheduleResponseDto update(Long id, ScheduleUpdateRequestDto requestDto);

    void delete(Long id);
}
