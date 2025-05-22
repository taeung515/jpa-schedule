package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;

public interface UserService {
    UserResponseDto signUp(UserSignUpRequestDto requestDto);

    UserResponseDto findById(Long id);

    UserResponseDto update(Long id, UserUpdateRequestDto requestDto);

    void delete(Long id);
}
