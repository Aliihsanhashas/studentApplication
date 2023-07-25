package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.repository.LessonRepository;

public class LessonServices {
    private final LessonRepository lessonRepository;

    public LessonServices(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


}
