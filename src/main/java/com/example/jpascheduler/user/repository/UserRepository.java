package com.example.jpascheduler.user.repository;

import com.example.jpascheduler.common.exception.UserNotFoundException;
import com.example.jpascheduler.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

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
                        new UserNotFoundException("해당 유저를 찾을 수 없습니다!")
                );
    }

}
