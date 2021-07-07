package ru.otus.quiz.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.quiz.configuration.QuizConfiguration;

class EstimateServiceImplTest {

    @Test
    void testEstimationResults() {
        ConsoleService consoleMock = Mockito.mock(ConsoleService.class);
        EstimateServiceImpl estimateService = new EstimateServiceImpl(new QuizConfiguration().setPathRate(50), consoleMock);
        Assertions.assertThat(estimateService.getResult( 5, 3)).isTrue();
        Assertions.assertThat(estimateService.getResult( 5, 2)).isFalse();
    }
}