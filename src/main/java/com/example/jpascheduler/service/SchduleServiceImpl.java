package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;
import com.example.jpascheduler.domain.entity.Schedule;
import com.example.jpascheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    @Override
    public ScheduleResponseDto findById(Long id) {
        return ScheduleResponseDto.toDto(scheduleRepository.findByIdOrElseThrow(id));
    }

    @Override
    public ScheduleResponseDto update(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.editSchedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        return ScheduleResponseDto.toDto(schedule);
    }
}
