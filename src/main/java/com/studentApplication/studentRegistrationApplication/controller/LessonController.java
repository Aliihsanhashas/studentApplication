package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.service.LessonServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/lessons")
public class LessonController {
    private final LessonServices lessonServices;

    public LessonController(LessonServices lessonServices) {
        this.lessonServices = lessonServices;
    }



}
