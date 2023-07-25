package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;

@Entity
@Table
public class Lesson {
    @Id
    @SequenceGenerator(
            name = "lesson_squence",
            sequenceName = "lesson_squence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_squence"
    )

    private Long id;
    private String name;
    private String teacher;
    private int credits;

    public Lesson() {

    }

    public Lesson(String name, String teacher, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.credits = credits;
    }

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
