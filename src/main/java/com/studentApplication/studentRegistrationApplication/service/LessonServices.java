package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.lesson.LessonRequestDto;
import com.studentApplication.studentRegistrationApplication.dto.lesson.LessonResponseDto;
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


    public Lesson addNewLesson(LessonRequestDto lessonRequestDto) {
        Lesson lesson = new Lesson();
        lesson.setName(lessonRequestDto.getName());
        lesson.setCredits(lessonRequestDto.getCredits());

        return lessonRepository.save(lesson);
    }

    public List<LessonResponseDto> getLessons() {
        return lessonRepository.findAll().stream()
                .map(this::getLessonResponseDtoByLesson)
                .collect(Collectors.toList());
    }

    private LessonResponseDto getLessonResponseDtoByLesson(Lesson lesson) {
        LessonResponseDto lessonResponseDto = new LessonResponseDto();

        lessonResponseDto.setId(lesson.getId());
        lessonResponseDto.setName(lesson.getName());
        lessonResponseDto.setCredits(lesson.getCredits());

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
