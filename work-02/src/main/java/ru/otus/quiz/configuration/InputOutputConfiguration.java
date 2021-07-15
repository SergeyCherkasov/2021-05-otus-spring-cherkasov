package ru.otus.quiz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.quiz.service.InputOutputService;
import ru.otus.quiz.service.InputOutputServiceImpl;

@Configuration
public class InputOutputConfiguration {
    @Bean
    public InputOutputService inputOutputService() {
        return new InputOutputServiceImpl(System.out, System.in);
    }
}
