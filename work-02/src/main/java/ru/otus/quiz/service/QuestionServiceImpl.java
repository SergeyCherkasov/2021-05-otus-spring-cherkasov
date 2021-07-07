package ru.otus.quiz.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.quiz.domain.Question;

@Component
@Data
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final ConsoleService consoleService;

    @Override
    public void printQuestion(Question question) {
        consoleService.printf("Question %1$s: %2$s?\n", question.getId(), question.getText());
        question.getAnswers().forEach((key, value) -> consoleService.printf("\t%1$s) %2$s\n", key, value));
    }

    public String getAnswer(Question question) {
        consoleService.printf("And your answer for %1$s is: ", question.getId());
        return consoleService.read();
    }

    @Override
    public boolean checkAnswer(Question question, String answer) {
        return question.getCorrectAnswerIndex().equals(answer);
    }

    @Override
    public void printResult(boolean result) {
        consoleService.printf("Result: %1$s\n\n", result ? "correct" : "wrong");
    }


}
