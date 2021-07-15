package ru.otus.quiz.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Question {
    private int id;
    private String text;
    private String correctAnswerIndex;
    @Setter(AccessLevel.NONE)
    private List<Answer> answers;

    public Question addAnswer(String index, String answer) {
        if(this.answers == null) {
            this.answers = new ArrayList<>();
        }
        this.answers.add(new Answer().setIndex(index).setText(answer));
        return this;
    }

    public Question addAnswers(List<Answer> answers) {
        if(this.answers == null) {
            this.answers = new ArrayList<>();
        }
        this.answers.addAll(answers);
        return this;
    }

    public List<Answer> getAnswers() {
        return Collections.unmodifiableList(this.answers);
    }
}
