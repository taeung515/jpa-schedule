package com.example.jpascheduler.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Setter
    @Column(nullable = false)
    public String username;

    @Column(nullable = false, unique = true)
    public String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {
    }
}
