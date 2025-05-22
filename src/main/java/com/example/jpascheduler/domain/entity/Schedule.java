package com.example.jpascheduler.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {
    }

    public void editSchedule(String username, String title, String contents) {
        if (Strings.isNotBlank(username)) {
            user.setUsername(username);
        }
        if (Strings.isNotBlank(title)) {
            this.title = title;
        }
        if (Strings.isNotBlank(contents)) {
            this.contents = contents;
        }
    }

}
