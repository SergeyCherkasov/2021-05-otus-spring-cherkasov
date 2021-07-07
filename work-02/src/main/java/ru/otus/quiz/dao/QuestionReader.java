package ru.otus.quiz.dao;

import ru.otus.quiz.domain.Question;
import ru.otus.quiz.exceptions.QuestionSourceReadException;

import java.util.List;

public interface QuestionReader {
    List<Question> readAllQuestions() throws QuestionSourceReadException;
}
