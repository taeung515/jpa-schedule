package com.example.jpascheduler.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Table(name = "user")
@Getter
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    public Schedule(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {
    }

    public void editSchedule(String username, String title, String contents) {
        if (Strings.isNotBlank(username)) {
            this.username = username;
        }
        if (Strings.isNotBlank(title)) {
            this.title = title;
        }
        if (Strings.isNotBlank(contents)) {
            this.contents = contents;
        }
    }

}
