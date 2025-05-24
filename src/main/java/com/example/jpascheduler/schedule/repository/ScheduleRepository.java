package com.example.jpascheduler.schedule.repository;

import com.example.jpascheduler.common.exception.ScheduleNotFoundException;
import com.example.jpascheduler.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ScheduleNotFoundException("해당 일정을 찾을 수 없습니다!")
                );
    }

    void deleteAllByUserId(Long userid);
}
