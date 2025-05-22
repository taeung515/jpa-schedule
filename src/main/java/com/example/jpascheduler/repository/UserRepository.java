package com.example.jpascheduler.repository;

import com.example.jpascheduler.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
