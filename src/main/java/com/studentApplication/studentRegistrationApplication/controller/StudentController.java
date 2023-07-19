package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.StudentRequestDto;
import com.studentApplication.studentRegistrationApplication.dto.StudentResponseDto;
import com.studentApplication.studentRegistrationApplication.model.Student;
import com.studentApplication.studentRegistrationApplication.service.StudentServices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @RestController annotasyonu, Spring Boot uygulamasında bir API sunucusu oluşturmak için kullanılan
 * @Controller annotasyonunun özelleştirilmiş bir versiyonudur.
 */
@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }


    /**
     * Dependencyleri otomatik olarak enjekte eder.Sınıflar arası bağlılıkları otomatik çözebilir.
     * Nesneleri enjekte edebilir.
     * private final StudentServices studentServices bunu kullanırken işimize yarayacak.
     */


    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {  //api aracılıgı ile geri dönderme
        return ResponseEntity.ok(studentServices.getStudents());
    }

    @GetMapping("/getstudentid/{studentId}")
    public ResponseEntity<Student> getStudentId(@PathVariable("studentId") Long studentId) {
        return ResponseEntity.ok(studentServices.getStudentById(studentId));

    }


    @PostMapping
    public ResponseEntity<Student> registrationNewStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(studentServices.addNewStudent(studentRequestDto));
    }

    @PutMapping("{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,
                                                 @RequestParam String name,
                                                 @RequestParam String lastName) {

        return ResponseEntity.ok(studentServices.updateStudent(studentId, name, lastName));
    }


    @DeleteMapping("{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentServices.deleteStudent(studentId));
    }

    @GetMapping("/findbylastname/{lastName}")
    public ResponseEntity<Student> findByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(studentServices.findByLastName(lastName));
    }

    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<Student> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentServices.findByEmail(email));
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<Student> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentServices.findByName(name));
    }


}
