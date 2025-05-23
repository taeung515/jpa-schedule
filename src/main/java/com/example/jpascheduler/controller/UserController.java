package com.example.jpascheduler.controller;

import com.example.jpascheduler.domain.dto.user.UserLoginRequestDto;
import com.example.jpascheduler.domain.dto.user.UserResponseDto;
import com.example.jpascheduler.domain.dto.user.UserSignUpRequestDto;
import com.example.jpascheduler.domain.dto.user.UserUpdateRequestDto;
import com.example.jpascheduler.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.jpascheduler.common.constant.Constants.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto) {
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

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @RequestBody UserLoginRequestDto requestDto,
            HttpSession session
    ) {
        userService.login(requestDto);
        session.setAttribute(SESSION_USER_EMAIL, requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session, HttpServletResponse response) {

        if (session != null) {
            session.invalidate();
        }

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
