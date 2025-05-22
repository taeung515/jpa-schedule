package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpResponseDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;

import java.util.List;

public interface UserService {
    UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto);

    UserResponseDto findById(Long id);

    UserResponseDto update(Long id, UserUpdateRequestDto requestDto);

    void delete(Long id);
}
