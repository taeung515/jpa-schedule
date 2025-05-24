package com.example.jpascheduler.user.service;

import com.example.jpascheduler.user.dto.UserLoginRequestDto;
import com.example.jpascheduler.user.dto.UserResponseDto;
import com.example.jpascheduler.user.dto.UserSignUpRequestDto;
import com.example.jpascheduler.user.dto.UserUpdateRequestDto;

public interface UserService {
    UserResponseDto signUp(UserSignUpRequestDto requestDto);

    UserResponseDto findById(Long id);

    UserResponseDto update(Long id, UserUpdateRequestDto requestDto);

    void delete(Long id);

    UserResponseDto login(UserLoginRequestDto requestDto);
}
