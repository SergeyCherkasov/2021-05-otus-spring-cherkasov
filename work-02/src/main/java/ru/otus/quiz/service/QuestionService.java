package ru.otus.quiz.service;

import ru.otus.quiz.domain.Question;

public interface QuestionService {
    void printQuestion(Question question);

    String getAnswer(Question question);

    boolean checkAnswer(Question question, String answer);

    void printResult(boolean result);

    default boolean askQuestion(Question question) {
        this.printQuestion(question);
        boolean result = this.checkAnswer(question, this.getAnswer(question));
        this.printResult(result);
        return result;
    }
}
