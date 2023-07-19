package com.studentApplication.studentRegistrationApplication.model;

import javax.persistence.*;

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
    private String name;
    private String lastName;
    private String email;

    public Student() {

    }

    public Student(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;

    }

    public Student(Long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
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
