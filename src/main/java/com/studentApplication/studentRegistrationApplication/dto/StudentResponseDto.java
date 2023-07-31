package com.studentApplication.studentRegistrationApplication.dto;

import com.studentApplication.studentRegistrationApplication.model.Lesson;
import com.studentApplication.studentRegistrationApplication.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * bu sınıfı student'in hepsini çekmemek icin actık.
 */
public class StudentResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;


    public long getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
