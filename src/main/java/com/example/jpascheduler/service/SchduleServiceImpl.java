package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;
import com.example.jpascheduler.domain.entity.Schedule;
import com.example.jpascheduler.domain.entity.User;
import com.example.jpascheduler.repository.ScheduleRepository;
import com.example.jpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchduleServiceImpl implements SchduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    public ScheduleResponseDto save(ScheduleRequestDto dto) {

        User userByEmail = userRepository.findUserByEmailOrElseThrow(dto.getEmail());

        Schedule schedule = new Schedule(dto.getTitle(), dto.getContents());
        schedule.setUser(userByEmail);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponseDto.toDto(savedSchedule);
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
        schedule.editSchedule(requestDto.getTitle(), requestDto.getContents());

        Schedule saved = scheduleRepository.save(schedule);
        return ScheduleResponseDto.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }
}
