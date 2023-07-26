package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.LessonResponseDto;
import com.studentApplication.studentRegistrationApplication.service.LessonServices;
import com.studentApplication.studentRegistrationApplication.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/lessons")
public class LessonController {
    private final LessonServices lessonServices;

    public LessonController(LessonServices lessonServices) {
        this.lessonServices = lessonServices;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllLessons() {
        return ResponseEntity.ok(new ApiResponse<>(lessonServices.getLessons(), "show lesson"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> addNewLesson(@RequestBody LessonResponseDto lessonResponseDto) {
        return ResponseEntity.ok(new ApiResponse<>(lessonServices.addNewLesson(lessonResponseDto), "succesfully add new lesson"));

    }


}
