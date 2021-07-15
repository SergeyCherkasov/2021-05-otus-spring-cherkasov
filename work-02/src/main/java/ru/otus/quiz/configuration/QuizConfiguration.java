package ru.otus.quiz.configuration;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@Accessors(chain = true)
public class QuizConfiguration {
    private final int pathRate;

    public QuizConfiguration(@Value("${quiz.pass.rate}") int pathRate) {
        this.pathRate = pathRate;
    }
}
