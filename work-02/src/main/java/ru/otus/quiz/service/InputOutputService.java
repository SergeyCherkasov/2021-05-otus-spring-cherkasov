package ru.otus.quiz.service;

public interface InputOutputService {
    void printf(String msg, Object... args);
    String read();
}
