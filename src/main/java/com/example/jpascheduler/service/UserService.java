package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpResponseDto;

public interface UserService {
    UserSignUpResponseDto signUp(UserSignUpRequestDto requestDto);
}
