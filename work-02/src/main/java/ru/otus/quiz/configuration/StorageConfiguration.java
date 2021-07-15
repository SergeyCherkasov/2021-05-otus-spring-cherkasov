package ru.otus.quiz.configuration;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@Accessors(chain = true)
public class StorageConfiguration {
    private final String csvPath;

    public StorageConfiguration(@Value("${quiz.csv.path}") String csvPath) {
        this.csvPath = csvPath;
    }
}
