package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.lesson.LessonRequestDto;
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
    public ResponseEntity<ApiResponse<Object>> addNewLesson(@RequestBody LessonRequestDto lessonRequestDto) {
        return ResponseEntity.ok(new ApiResponse<>(lessonServices.addNewLesson(lessonRequestDto), "succesfully add new lesson"));
    }

    @DeleteMapping("/{lessonId}")
    public ResponseEntity<ApiResponse<Object>> deleteLesson(@PathVariable Long lessonId){
        return ResponseEntity.ok(new ApiResponse<>(lessonServices.delete(lessonId),"Deleted lesson"));
    }

}
