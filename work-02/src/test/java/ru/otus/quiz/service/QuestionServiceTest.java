package ru.otus.quiz.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.quiz.Application;
import ru.otus.quiz.configuration.QuizConfiguration;
import ru.otus.quiz.dao.QuestionReader;
import ru.otus.quiz.domain.Question;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Application.class)
@TestPropertySource("classpath:application-test.properties")
class QuestionServiceTest {
    @Autowired
    private QuestionReader questionReader;
    @MockBean
    private InputOutputService inputOutputServiceMock;
    @Autowired
    private QuestionService questionService;

    @Test
    void askQuestion() {
        Mockito.when(inputOutputServiceMock.read()).thenReturn("a");
        Question question = questionReader.readAllQuestions().get(0);
        Assertions.assertThat(questionService.askQuestion(question)).isTrue();
    }
}