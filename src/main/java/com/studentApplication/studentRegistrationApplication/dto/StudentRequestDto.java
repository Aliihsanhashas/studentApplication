package com.studentApplication.studentRegistrationApplication.dto;

import com.studentApplication.studentRegistrationApplication.model.Lesson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * bu sınıfı postmana request yapmak icin actık.
 * responseden farkı bazı verileri icermiyor.
 */

public class StudentRequestDto {
    private String name;
    private String lastName;
    private String email;

    private List<Lesson> lessons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
