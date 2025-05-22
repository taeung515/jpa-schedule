package com.example.jpascheduler.controller;

import com.example.jpascheduler.domain.dto.schedule.ScheduleRequestDto;
import com.example.jpascheduler.domain.dto.schedule.ScheduleResponseDto;
import com.example.jpascheduler.service.SchduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> responseDtoList = schduleService.findAll();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        ScheduleResponseDto foundResponseDto = schduleService.findById(id);
        return new ResponseEntity<>(foundResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto updatedResponseDto = schduleService.update(id, requestDto);
        return new ResponseEntity<>(updatedResponseDto, HttpStatus.OK);
    }
}
