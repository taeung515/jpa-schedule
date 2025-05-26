package com.example.jpascheduler.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Vaild 예외 발생
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: ");
            builder.append(fieldError.getRejectedValue());
            builder.append("\n");
        }

        return builder.toString();
    }

    // 유저를 찾을 수 없을 때
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFound(UserNotFoundException exception) {
        ErrorResponseDto response = new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 일정을 찾을 수 없을 때
    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleScheduleNotFoundException(ScheduleNotFoundException exception) {
        ErrorResponseDto response = new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 비밀번호가 미일치
    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorResponseDto> handlePasswordMismatchException(PasswordMismatchException exception) {
        ErrorResponseDto response = new ErrorResponseDto(
                HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    // 로그인 하지 않고 접근
    @ExceptionHandler(LoginRequiredException.class)
    public ResponseEntity<ErrorResponseDto> handleLoginRequiredException(LoginRequiredException exception) {
        ErrorResponseDto response = new ErrorResponseDto(
                HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    // 회원탈퇴 시 본인이 아닐 때
    @ExceptionHandler(UnauthorizedSessionException.class)
    public ResponseEntity<ErrorResponseDto> handleUnauthorizedSessionException(UnauthorizedSessionException exception) {
        ErrorResponseDto response = new ErrorResponseDto(
                HttpStatus.FORBIDDEN.value(),
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}





