package com.studentApplication.studentRegistrationApplication.dto.teacher;

import com.studentApplication.studentRegistrationApplication.model.Lesson;


public class TeacherResponseDto {
    private Long id;

    private String name;

    private Lesson lesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
