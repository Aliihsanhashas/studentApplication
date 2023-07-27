package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.TeacherResponseDto;
import com.studentApplication.studentRegistrationApplication.service.TeacherService;
import com.studentApplication.studentRegistrationApplication.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> addNewTeacher(@RequestBody TeacherResponseDto teacherResponseDto) {
        return ResponseEntity.ok(new ApiResponse<>(teacherService.addNewTeacher(teacherResponseDto), "add new teacher"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllTeacher(){
        return ResponseEntity.ok(new ApiResponse<>(teacherService.getAllTeacher(),"show teacher"));
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<ApiResponse<Object>> deleteTeacher(@PathVariable Long teacherId){
        return ResponseEntity.ok(new ApiResponse<>(teacherService.deleteTeacher(teacherId),"Delete Teacher"));
    }


}

