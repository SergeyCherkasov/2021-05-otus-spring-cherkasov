package ru.otus.quiz.service;

import ru.otus.quiz.dao.QuestionReader;
import ru.otus.quiz.domain.Question;
import ru.otus.quiz.exceptions.QuestionSourceReadException;

import java.util.List;

public class QuizService {
    private final QuestionReader questionReader;
    private final QuestionPrinter questionPrinter;

    public QuizService(QuestionReader questionReader, QuestionPrinter questionPrinter) {
        this.questionReader = questionReader;
        this.questionPrinter = questionPrinter;
    }

    public void printAllQuestions() throws QuestionSourceReadException {
        List<Question> questions = questionReader.readAllQuestions();
        questions.forEach(questionPrinter::print);
    };
}
