package com.studentApplication.studentRegistrationApplication.dto.lesson;


public class LessonRequestDto {
    private String name;
    private int credits;

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
}
