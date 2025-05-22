package com.example.jpascheduler.repository;

import com.example.jpascheduler.domain.entity.Schedule;
import com.example.jpascheduler.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "해당id로 조회되는 회원이 없습니다." + id
                        )
                );
    }

}
