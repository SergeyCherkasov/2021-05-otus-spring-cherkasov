package ru.otus.quiz.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Question {
    private int id;
    private String text;
    private String correctAnswerIndex;
    private Map<String, String> answers;
}
