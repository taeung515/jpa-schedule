package com.example.jpascheduler.schedule.controller;

import com.example.jpascheduler.schedule.dto.ScheduleRequestDto;
import com.example.jpascheduler.schedule.dto.ScheduleResponseDto;
import com.example.jpascheduler.schedule.dto.ScheduleUpdateRequestDto;
import com.example.jpascheduler.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @RequestBody ScheduleRequestDto dto) {
        ScheduleResponseDto responseDto = scheduleService.save(dto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> responseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        ScheduleResponseDto foundResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(foundResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleUpdateRequestDto requestDto
    ) {
        ScheduleResponseDto updatedResponseDto = scheduleService.update(id, requestDto);
        return new ResponseEntity<>(updatedResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
