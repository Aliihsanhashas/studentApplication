package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
    private int credits = 0;

    @ManyToOne
    private Student students;

    @OneToOne
    private Teacher teacher;


    public Lesson() {
    }

    public Lesson(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public Lesson(Long id, String name, int credits) {
        this.id = id;
        this.name = name;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
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
                ", students=" + students +
                '}';
    }
}
