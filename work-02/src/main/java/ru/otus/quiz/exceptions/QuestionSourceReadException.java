package ru.otus.quiz.exceptions;

public class QuestionSourceReadException extends RuntimeException {
    public QuestionSourceReadException() {
        super();
    }

    public QuestionSourceReadException(String message) {
        super(message);
    }

    public QuestionSourceReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
