package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String name;
    @NotBlank
    private int credits;
    @OneToOne
    private Teacher teacher;

    public Lesson() {
    }

    public Lesson(String name, int credits, Teacher teacher) {
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
    }

    public Lesson(Long id, String name, int credits, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", teacher=" + teacher +
                '}';
    }
}
