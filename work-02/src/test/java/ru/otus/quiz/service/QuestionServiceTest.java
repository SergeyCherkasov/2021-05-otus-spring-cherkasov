package ru.otus.quiz.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import ru.otus.quiz.Application;
import ru.otus.quiz.configuration.QuizConfiguration;
import ru.otus.quiz.dao.QuestionReader;
import ru.otus.quiz.domain.Question;

@SpringBootTest(classes = Application.class)
@TestPropertySource("classpath:application-test.properties")
class QuestionServiceTest {
    @Autowired
    private QuestionReader questionReader;
    @MockBean
    private InputOutputServiceImpl consoleMock;
    @Autowired
    private QuestionService questionService;

    @Test
    void askQuestion() {
        Mockito.when(consoleMock.read()).thenReturn("a");
        Question question = questionReader.readAllQuestions().get(0);
        Assertions.assertThat(questionService.askQuestion(question)).isTrue();
    }
}