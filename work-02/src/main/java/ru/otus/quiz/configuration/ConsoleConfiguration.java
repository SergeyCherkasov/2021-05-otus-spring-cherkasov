package ru.otus.quiz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.quiz.service.ConsoleService;

@Configuration
public class ConsoleConfiguration {
    @Bean
    public ConsoleService getConsoleService() {
        return new ConsoleService(System.out, System.in);
    }
}
