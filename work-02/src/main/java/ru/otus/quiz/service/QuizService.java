package ru.otus.quiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quiz.dao.QuestionReader;
import ru.otus.quiz.domain.Question;
import ru.otus.quiz.domain.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuestionReader questionReader;
    private final QuestionService questionService;
    private final StudentService studentService;
    private final EstimateService estimateService;

    public void runQuiz() {
        Student student = studentService.introduceStudent();
        List<Question> questions = questionReader.readAllQuestions();
        int correctAnswersCount = (int) questions.stream().filter(questionService::askQuestion).count();
        estimateService.estimate(student, questions.size(), correctAnswersCount);
    }
}
