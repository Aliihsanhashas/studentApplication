package com.studentApplication.studentRegistrationApplication.dto;

/**
 * bu sınıfı postmana request yapmak icin actık.
 * responseden farkı bazı verileri icermiyor.
 */

public class StudentRequestDto {
    private String name;
    private String lastName;
    private String email;

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

}
