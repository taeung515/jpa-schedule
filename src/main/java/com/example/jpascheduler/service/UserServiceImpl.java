package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;
import com.example.jpascheduler.domain.entity.User;
import com.example.jpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto signUp(UserSignUpRequestDto requestDto) {

        User user = new User(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Override
    public UserResponseDto findById(Long id) {

        User user = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    public UserResponseDto update(Long id, UserUpdateRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(id);
        user.editUser(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }
}
