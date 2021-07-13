package ru.otus.quiz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.quiz.service.InputOutputServiceImpl;

@Configuration
public class ConsoleConfiguration {
    @Bean
    public InputOutputServiceImpl getConsoleService() {
        return new InputOutputServiceImpl(System.out, System.in);
    }
}
