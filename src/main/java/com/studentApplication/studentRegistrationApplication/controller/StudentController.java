package com.studentApplication.studentRegistrationApplication.controller;

import com.studentApplication.studentRegistrationApplication.dto.LessonResponseDto;
import com.studentApplication.studentRegistrationApplication.dto.StudentRequestDto;
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
    public ResponseEntity<ApiResponse<Object>> getAllStudents() {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.getStudents(), "show students."));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> registrationNewStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.addNewStudent(studentRequestDto), "successfully registered."));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse<Object>> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.findStudentByIdOrElseThrowException(studentId), "student successfully found."));
    }

    @PutMapping("{studentId}")
    public ResponseEntity<ApiResponse<Object>> updateStudent(@PathVariable Long studentId,
                                                             @RequestParam String name,
                                                             @RequestParam String lastName,
                                                             @RequestParam String email) {// TODO conver to StudentRequestDto

        return ResponseEntity.ok(new ApiResponse<>(studentServices.updateStudent(studentId, name, lastName, email), "update student."));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse<Object>> deleteStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.deleteStudent(studentId), "student deleted."));
    }

    @GetMapping("/get/lastname/{lastName}")
    public ResponseEntity<ApiResponse<Object>> findByLastName(@PathVariable String lastName) {

        return ResponseEntity.ok(new ApiResponse<>(studentServices.findByLastNameOrElseThrowException(lastName), "student successfully found."));
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<ApiResponse<Object>> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.findByEmailOrElseThrowException(email), "student successfully found."));
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<ApiResponse<Object>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(new ApiResponse<>(studentServices.findByNameOrElseThrowException(name), "student succesfully found."));
    }

}
