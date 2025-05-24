package com.example.jpascheduler.user.repository;

import com.example.jpascheduler.common.exception.UserNotFoundException;
import com.example.jpascheduler.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    default User findUserByEmailOrElseThrow(String email) {
        return findUserByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("해당 유저를 찾을 수 없습니다!")
                );
    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "해당id로 조회되는 회원이 없습니다!" + id
                        )
                );
    }

}
