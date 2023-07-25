package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServices {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServices(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


}
