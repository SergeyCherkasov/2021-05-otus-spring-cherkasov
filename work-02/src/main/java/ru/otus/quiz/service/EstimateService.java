package ru.otus.quiz.service;

import ru.otus.quiz.domain.Student;

public interface EstimateService {
    void estimate(Student student, int questionCount, int correctCount);
}
