package com.example.jpascheduler.controller;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;
import com.example.jpascheduler.service.SchduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final SchduleService schduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto) {
        ScheduleResponseDto responseDto = schduleService.save(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
