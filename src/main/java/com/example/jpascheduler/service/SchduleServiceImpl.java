package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;
import com.example.jpascheduler.domain.entity.Schedule;
import com.example.jpascheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchduleServiceImpl implements SchduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto save(ScheduleRequestDto dto) {

        Schedule schedule = new Schedule(dto.getUsername(), dto.getTitle(), dto.getContents());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUsername(),
                savedSchedule.getTitle(),
                savedSchedule.getContents());
    }
}
