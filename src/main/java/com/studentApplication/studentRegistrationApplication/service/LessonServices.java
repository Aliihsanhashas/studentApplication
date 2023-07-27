package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.LessonResponseDto;
import com.studentApplication.studentRegistrationApplication.model.Lesson;
import com.studentApplication.studentRegistrationApplication.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServices {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServices(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    public Lesson addNewLesson(LessonResponseDto lessonResponseDto) {
        Lesson lesson = new Lesson();
        lesson.setName(lessonResponseDto.getName());
        lesson.setCredits(lessonResponseDto.getCredits());
        lesson.setTeacher(lessonResponseDto.getTeacher());

        return lessonRepository.save(lesson);
    }

    public List<LessonResponseDto> getLessons() {
        return lessonRepository.findAll().stream()
                .map(this::getLessonResponseDtoByLesson)
                .collect(Collectors.toList());
    }

    private LessonResponseDto getLessonResponseDtoByLesson(Lesson lesson) {
        LessonResponseDto lessonResponseDto = new LessonResponseDto();

        lessonResponseDto.setName(lesson.getName());
        lessonResponseDto.setCredits(lesson.getCredits());
        lessonResponseDto.setTeacher(lesson.getTeacher());
        lessonResponseDto.setId(lesson.getId());

        return lessonResponseDto;
    }

    public Long delete(Long lessonId) {
        Lesson lesson = findLessonByIdOrElseThrowException(lessonId);
        lessonRepository.delete(lesson);
        return lesson.getId();
    }

    public Lesson findLessonByIdOrElseThrowException(Long lessonId) {
        return lessonRepository.findById(lessonId).orElseThrow();
    }


}
