package com.example.jpascheduler.service;

import com.example.jpascheduler.domain.dto.user.UserLoginRequestDto;
import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;
import com.example.jpascheduler.domain.entity.User;
import com.example.jpascheduler.repository.ScheduleRepository;
import com.example.jpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public UserResponseDto signUp(UserSignUpRequestDto requestDto) {

        User user = new User(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {

        User user = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    @Transactional
    public UserResponseDto update(Long id, UserUpdateRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(id);
        user.editUser(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        scheduleRepository.deleteAllById(user.getId());

        userRepository.delete(user);
    }

    @Override
    public UserResponseDto login(UserLoginRequestDto requestDto) {
        User userByEmail = userRepository.findUserByEmailOrElseThrow(requestDto.getEmail());
        if (!userByEmail.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 틀립니다.");
        }
        return new UserResponseDto(userByEmail.getId(), userByEmail.getUsername(), userByEmail.getEmail());
    }
}
