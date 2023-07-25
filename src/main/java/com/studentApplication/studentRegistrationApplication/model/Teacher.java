package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_squence",
            sequenceName = "teacher_squence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_squence"
    )
    private Long id;
    @NotBlank
    private String name;
    @OneToOne
    @NotBlank
    private Lesson lesson;

    public Teacher() {

    }

    public Teacher(String name, Lesson lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    public Teacher(Long id, String name, Lesson lesson) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
