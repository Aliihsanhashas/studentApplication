package com.studentApplication.studentRegistrationApplication.repository;

import com.studentApplication.studentRegistrationApplication.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
