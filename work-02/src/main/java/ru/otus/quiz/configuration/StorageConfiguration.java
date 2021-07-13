package ru.otus.quiz.configuration;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Data
@Accessors(chain = true)
public class StorageConfiguration {
    private final String csvPath;

    public StorageConfiguration(@Value("${quiz.csv.path}") String csvPath) {
        this.csvPath = csvPath;
    }
}
