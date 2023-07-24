package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.StudentRequestDto;
import com.studentApplication.studentRegistrationApplication.model.Student;
import com.studentApplication.studentRegistrationApplication.service.StudentServices;
import com.studentApplication.studentRegistrationApplication.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<Object>> getAllStudents() {  //api aracılıgı ile geri dönderme
        return ResponseEntity.ok(new ApiResponse<>(studentServices.getStudents(), "student saved succes"));
    }

    @PostMapping
    public ResponseEntity<Student> registrationNewStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(studentServices.addNewStudent(studentRequestDto));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentServices.findStudentByIdOrElseThrowException(studentId));
    }


    @PutMapping("{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,
                                                 @RequestParam String name, // TODO conver to StudentRequestDto
                                                 @RequestParam String lastName,
                                                 @RequestParam String email) {

        return ResponseEntity.ok(studentServices.updateStudent(studentId, name, lastName, email));
    }


    @DeleteMapping("{studentId}")
    public ResponseEntity<Long> deleteStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentServices.deleteStudent(studentId));
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<Student> findByLastName(@PathVariable String lastName) {

        return ResponseEntity.ok(studentServices.findByLastName(lastName));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Student> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentServices.findByEmail(email));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Student> findByName(@PathVariable String name) {
        return ResponseEntity.ok(studentServices.findByName(name));
    }

}
