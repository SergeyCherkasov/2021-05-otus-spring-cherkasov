package ru.otus.quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quiz.domain.Question;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final InputOutputService inputOutputService;

    @Override
    public boolean askQuestion(Question question) {
        this.printQuestion(question);
        boolean result = this.checkAnswer(question, this.getAnswer(question));
        this.printResult(result);
        return result;
    }

    private void printQuestion(Question question) {
        inputOutputService.printf("Question %1$s: %2$s?\n", question.getId(), question.getText());
        question.getAnswers().forEach((answer) -> inputOutputService.printf("\t%1$s) %2$s\n", answer.getIndex(), answer.getText()));
    }

    private String getAnswer(Question question) {
        inputOutputService.printf("And your answer for %1$s is: ", question.getId());
        return inputOutputService.read();
    }

    private boolean checkAnswer(Question question, String answer) {
        return question.getCorrectAnswerIndex().equals(answer);
    }

    private void printResult(boolean result) {
        inputOutputService.printf("Result: %1$s\n\n", result ? "correct" : "wrong");
    }


}
