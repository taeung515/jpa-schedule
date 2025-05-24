package com.example.jpascheduler.user.entity;

import com.example.jpascheduler.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Table(name = "user")
@Getter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public void editUser(String username, String email, String password) {
        if (Strings.isNotBlank(username)) {
            this.username = username;
        }
        if (Strings.isNotBlank(email)) {
            this.email = email;
        }
        if (Strings.isNotBlank(password)) {
            this.password = password;
        }
    }
}
