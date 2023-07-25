package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Bir sınıfı @Entity ile işaretlediğinizde, Hibernate bu sınıfı bir veritabanı tablosuna eşleyebilir
// ve tablo ile nesne arasında bir ilişki kurabilir.
//---------------------------------------------------------------
//@Table annotasyonu, tablo adını ve diğer tablo seçeneklerini belirtmek için kullanılır.
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_squence",
            sequenceName = "student_squence",
            allocationSize = 1
    )
    //@GeneratedValue, bir varlık sınıfının birincil anahtarının nasıl oluşturulacağını belirlemek için kullanılan bir annotasyondur.
    //strategy: Birincil anahtar değerinin nasıl oluşturulacağını belirler. Örneğin, GenerationType.
    // AUTO, GenerationType.IDENTITY, GenerationType.SEQUENCE, GenerationType.TABLE gibi stratejiler kullanılabilir.
    //generator: Özel bir değer oluşturma stratejisi belirtmek için kullanılır. Bu, @SequenceGenerator veya @TableGenerator gibi özelleştirilmiş değer üreteçlerini referans edebilir.

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_squence"
    )
    private Long id;
    @NotBlank(message = "Must be not null.")
    private String name;
    @NotBlank(message = "Must be not null.")
    private String lastName;
    @Email(message = "Email shoul be valid.")
    @NotBlank(message = "Must be not null.")
    private String email;

    @ManyToOne
    private Lesson lesson;


    public Student() {

    }

    public Student(String name, String lastName, String email, Lesson lesson) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.lesson = lesson;

    }

    public Student(Long id, String name, String lastName, String email, Lesson lesson) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
