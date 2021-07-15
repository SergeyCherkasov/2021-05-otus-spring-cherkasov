package ru.otus.quiz.service;

import ru.otus.quiz.domain.Question;

public interface QuestionService {
    boolean askQuestion(Question question);
}
