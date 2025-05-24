package com.example.jpascheduler.user.controller;

import com.example.jpascheduler.common.exception.UnauthorizedSessionException;
import com.example.jpascheduler.user.dto.UserLoginRequestDto;
import com.example.jpascheduler.user.dto.UserResponseDto;
import com.example.jpascheduler.user.dto.UserSignUpRequestDto;
import com.example.jpascheduler.user.dto.UserUpdateRequestDto;
import com.example.jpascheduler.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static com.example.jpascheduler.common.constant.Constants.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@Valid @RequestBody UserSignUpRequestDto requestDto) {
        UserResponseDto UserResponseDto = userService.signUp(requestDto);
        return new ResponseEntity<>(UserResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto responseDto = userService.findById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequestDto requestDto
    ) {
        UserResponseDto updateDto = userService.update(id, requestDto);
        return new ResponseEntity<>(updateDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            HttpSession session
    ) {

        Long sessionUserId = (Long) session.getAttribute(SESSION_USER_ID);

        if (!sessionUserId.equals(id)) {
            throw new UnauthorizedSessionException("본인만 삭제할 수 있습니다.");
        }

        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @Valid @RequestBody UserLoginRequestDto requestDto,
            HttpSession session
    ) {
        UserResponseDto logined = userService.login(requestDto);
        session.setAttribute(SESSION_USER_ID, logined.getId());
        return new ResponseEntity<>(logined, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session, HttpServletResponse response) {

        session.invalidate();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
