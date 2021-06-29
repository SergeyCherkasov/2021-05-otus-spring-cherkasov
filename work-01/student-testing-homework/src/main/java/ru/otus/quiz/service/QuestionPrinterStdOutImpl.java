package ru.otus.quiz.service;

import ru.otus.quiz.domain.Question;

import java.io.PrintWriter;

public class QuestionPrinterStdOutImpl implements QuestionPrinter {

    @Override
    public void print(Question question) {
        PrintWriter pw = new PrintWriter(System.out);
        pw.printf("Question %1$s: %2$s?\n", question.getId(), question.getText());
        question.getAnswers().entrySet().forEach(entry -> pw.printf("\t%1$s) %2$s\n", entry.getKey(), entry.getValue()));
        pw.flush();
    }
}
