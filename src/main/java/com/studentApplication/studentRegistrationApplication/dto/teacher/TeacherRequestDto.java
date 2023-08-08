package com.studentApplication.studentRegistrationApplication.dto.teacher;

import com.studentApplication.studentRegistrationApplication.model.Lesson;


public class TeacherRequestDto {

    private String name;
    private Lesson lesson;

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
