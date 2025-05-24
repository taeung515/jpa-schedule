package com.example.jpascheduler.schedule.service;

import com.example.jpascheduler.schedule.entity.Schedule;
import com.example.jpascheduler.schedule.repository.ScheduleRepository;
import com.example.jpascheduler.schedule.dto.ScheduleRequestDto;
import com.example.jpascheduler.schedule.dto.ScheduleResponseDto;
import com.example.jpascheduler.user.entity.User;
import com.example.jpascheduler.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.editSchedule(requestDto.getTitle(), requestDto.getContents());
        return ScheduleResponseDto.toDto(schedule);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }
}
