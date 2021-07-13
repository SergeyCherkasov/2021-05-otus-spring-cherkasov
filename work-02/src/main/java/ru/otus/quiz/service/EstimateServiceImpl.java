package ru.otus.quiz.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quiz.configuration.QuizConfiguration;
import ru.otus.quiz.domain.Student;

@Service
@RequiredArgsConstructor
public class EstimateServiceImpl implements EstimateService {
    private final static String PASS_MESSAGE = "you have passed the test! Congratulations!";
    private final static String FAIL_MESSAGE = "you have failed the test. Please try again.";
    private final QuizConfiguration config;
    private final InputOutputService inputOutputService;

    @Override
    public void estimate(Student student, int questionCount, int correctCount) {
        boolean result = getResult(questionCount, correctCount);
        inputOutputService.printf("%1$s %2$s, %3$s\n", student.getFirstName(), student.getLastName(), result ? PASS_MESSAGE : FAIL_MESSAGE);
    }

    public boolean getResult(int questionCount, int correctCount) {
        return 100 * correctCount / questionCount > config.getPathRate();
    }
}
