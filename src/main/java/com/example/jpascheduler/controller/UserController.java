package com.example.jpascheduler.controller;

import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpResponseDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;
import com.example.jpascheduler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto) {
        UserSignUpResponseDto userSignUpResponseDto = userService.signUp(requestDto);
        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto responseDto = userService.findById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequestDto requestDto
    ) {
        UserResponseDto updateDto = userService.update(id, requestDto);
        return new ResponseEntity<>(updateDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
