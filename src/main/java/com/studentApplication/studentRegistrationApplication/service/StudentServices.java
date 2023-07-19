package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.StudentRequestDto;
import com.studentApplication.studentRegistrationApplication.dto.StudentResponseDto;
import com.studentApplication.studentRegistrationApplication.model.Student;
import com.studentApplication.studentRegistrationApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service annotasyonu, bir sınıfın iş mantığını uygulamak ve işlemleri gerçekleştirmek için kullanılır.
// Bu sınıflar genellikle servis katmanında yer alır ve iş kurallarını uygulayarak diğer bileşenlerle iletişim kurar.
@Service
public class StudentServices {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDto> getStudents() {   //getAll student
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDto> responseDtoList = new ArrayList<>();

        for (Student student : studentList) {
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setLastName(student.getLastName());
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());

            responseDtoList.add(studentResponseDto);
        }

        return responseDtoList;
    }

    public Student addNewStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setLastName(studentRequestDto.getLastName());
        student.setEmail(studentRequestDto.getEmail());

        return studentRepository.save(student);
    }

    public boolean deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            return false;
        } else {
            studentRepository.deleteById(studentId);
            return true;
        }
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student updateStudent(Long studentId, String name, String lastName) {
        Student updateByStudent = getStudentById(studentId);
        if (updateByStudent == null) {
            return null;
        }
        updateByStudent.setLastName(lastName);
        updateByStudent.setName(name);
        studentRepository.save(updateByStudent);
        return updateByStudent;
    }

    public Student findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }


}
