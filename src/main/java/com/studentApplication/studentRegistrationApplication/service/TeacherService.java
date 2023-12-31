package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.teacher.TeacherRequestDto;
import com.studentApplication.studentRegistrationApplication.dto.teacher.TeacherResponseDto;
import com.studentApplication.studentRegistrationApplication.model.Lesson;
import com.studentApplication.studentRegistrationApplication.model.Teacher;
import com.studentApplication.studentRegistrationApplication.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final LessonServices lessonServices;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, LessonServices lessonServices) {
        this.teacherRepository = teacherRepository;
        this.lessonServices = lessonServices;
    }

    public Teacher addNewTeacher(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();

        teacher.setName(teacherRequestDto.getName());
        teacher.setLesson(teacherRequestDto.getLesson());

        return teacherRepository.save(teacher);
    }

    public List<TeacherResponseDto> getAllTeacher() {
        return teacherRepository.findAll().stream()
                .map(this::getTeacherResponseDtoByTeacher)
                .collect(Collectors.toList());
    }

    private TeacherResponseDto getTeacherResponseDtoByTeacher(Teacher teacher) {
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
        teacherResponseDto.setId(teacher.getId());
        teacherResponseDto.setName(teacher.getName());
        teacherResponseDto.setLesson(teacher.getLesson());

        return teacherResponseDto;
    }

    public Long deleteTeacher(Long teacherId) {
        Teacher teacher = findTeacherByIdOrElseThrowException(teacherId);
        teacherRepository.delete(teacher);
        return teacher.getId();
    }

    public Teacher findTeacherByIdOrElseThrowException(Long teacherId) {
        return teacherRepository.findById(teacherId).orElseThrow();

    }

    public Teacher addTeacherForLesson(Long lessonId, Long teacherId) {
        Lesson lesson = lessonServices.findLessonByIdOrElseThrowException(lessonId);
        Teacher teacher = this.findTeacherByIdOrElseThrowException(teacherId);
        teacher.setLesson(lesson);

        return teacherRepository.save(teacher);
    }
}
