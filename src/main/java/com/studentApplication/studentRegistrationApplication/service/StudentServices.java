package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.StudentRequestDto;
import com.studentApplication.studentRegistrationApplication.dto.StudentResponseDto;
import com.studentApplication.studentRegistrationApplication.exception.StudentNotFoundException;
import com.studentApplication.studentRegistrationApplication.model.Lesson;
import com.studentApplication.studentRegistrationApplication.model.Student;
import com.studentApplication.studentRegistrationApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service annotasyonu, bir sınıfın iş mantığını uygulamak ve işlemleri gerçekleştirmek için kullanılır.
// Bu sınıflar genellikle servis katmanında yer alır ve iş kurallarını uygulayarak diğer bileşenlerle iletişim kurar.
@Service
public class StudentServices {

    private final StudentRepository studentRepository;
    private final LessonServices lessonServices;

    @Autowired
    public StudentServices(StudentRepository studentRepository, LessonServices lessonServices) {
        this.studentRepository = studentRepository;
        this.lessonServices = lessonServices;
    }

    public List<StudentResponseDto> getStudents() {   //getAll student

        return studentRepository.findAll()
                .stream()// TODO learn java stream api
                .map(this::getStudentResponseDtoByStudent)
                .collect(Collectors.toList());
    }

    private StudentResponseDto getStudentResponseDtoByStudent(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());

        return studentResponseDto;
    }

    public Student addNewStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setLastName(studentRequestDto.getLastName());
        student.setEmail(studentRequestDto.getEmail());

        return studentRepository.save(student);
    }

    public Long deleteStudent(Long studentId) {
        Student student = findStudentByIdOrElseThrowException(studentId);
        studentRepository.delete(student);

        return student.getId();
    }

    public Student findStudentByIdOrElseThrowException(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("user not found by id: " + studentId));
    }

    public Student updateStudent(Long studentId, String name, String lastName, String email) {
        Student updateByStudent = this.findStudentByIdOrElseThrowException(studentId);

        updateByStudent.setLastName(lastName);
        updateByStudent.setName(name);
        updateByStudent.setEmail(email);

        return studentRepository.save(updateByStudent);
    }

    public Student findByLastNameOrElseThrowException(String lastName) {
        return studentRepository.findByLastName(lastName).orElseThrow(() -> new StudentNotFoundException("user not found by id: " + lastName));
    }

    public Student findByEmailOrElseThrowException(String email) {
        return studentRepository.findByEmail(email).orElseThrow(() -> new StudentNotFoundException("user not found by id: " + email));
    }

    public Student findByNameOrElseThrowException(String name) {
        return studentRepository.findByName(name).orElseThrow(() -> new StudentNotFoundException("user not found by id: " + name));
    }

    public Student addLessonForStudent(Long lessonId, Long studentId) {
        Lesson lesson = lessonServices.findLessonByIdOrElseThrowException(lessonId);
        Student student = this.findStudentByIdOrElseThrowException(studentId);
        List<Lesson> lessons = student.getLessons();
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        lessons.add(lesson);
        student.setLessons(lessons);

        return studentRepository.save(student);
    }

    public Student getAllLessonByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
        return student;
    }


}
