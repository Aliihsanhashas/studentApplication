package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.service.LessonServices;

public class LessonController {
    private final LessonServices lessonServices;

    public LessonController(LessonServices lessonServices) {
        this.lessonServices = lessonServices;
    }


}
