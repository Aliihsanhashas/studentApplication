package com.studentApplication.studentRegistrationApplication.dto;

import com.studentApplication.studentRegistrationApplication.model.Teacher;


public class LessonResponseDto {
    private Long id;

    private String name;

    private int credits;

    private Teacher teacher;

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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}