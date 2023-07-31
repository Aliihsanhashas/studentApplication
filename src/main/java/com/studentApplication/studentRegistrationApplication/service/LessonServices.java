package com.studentApplication.studentRegistrationApplication.service;

import com.studentApplication.studentRegistrationApplication.dto.LessonRequestDto;
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

    public List<LessonRequestDto> getLessons() {
        return lessonRepository.findAll().stream()
                .map(this::getLessonResponseDtoByLesson)
                .collect(Collectors.toList());
    }

    private LessonRequestDto getLessonResponseDtoByLesson(Lesson lesson) {
        LessonRequestDto lessonRequestDto = new LessonRequestDto();

        lessonRequestDto.setName(lesson.getName());
        lessonRequestDto.setCredits(lesson.getCredits());
        lessonRequestDto.setId(lesson.getId());

        return lessonRequestDto;
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
