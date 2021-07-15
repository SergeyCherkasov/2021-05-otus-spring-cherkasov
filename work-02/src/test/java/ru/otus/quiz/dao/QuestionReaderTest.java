package ru.otus.quiz.dao;

import org.junit.jupiter.api.Test;
import ru.otus.quiz.configuration.StorageConfiguration;
import ru.otus.quiz.domain.Answer;
import ru.otus.quiz.domain.Question;
import ru.otus.quiz.exceptions.QuestionSourceReadException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuestionReaderTest {
    private final static String NOT_EXISTING_FILE = "notexist";
    private final static String INVALID_FILE = "invalidQuestion.csv";
    private final static String VALID_FILE = "validQuestion.csv";

    @Test
    void testMissingFileException() {
        final StorageConfiguration conf = new StorageConfiguration(NOT_EXISTING_FILE);
        QuestionReader questionReader = new QuestionReaderCsvImpl(conf);
        assertThatThrownBy(questionReader::readAllQuestions).isInstanceOf(QuestionSourceReadException.class);
    }

    @Test
    void  testInvalidFileException() {
        final StorageConfiguration conf = new StorageConfiguration(INVALID_FILE);
        QuestionReader questionReader = new QuestionReaderCsvImpl(conf);
        assertThatThrownBy(questionReader::readAllQuestions).isInstanceOf(QuestionSourceReadException.class);
    }

    @Test
    void testSuccessfulFileRead() throws QuestionSourceReadException {
        final StorageConfiguration conf = new StorageConfiguration(VALID_FILE);
        QuestionReader reader = new QuestionReaderCsvImpl(conf);
        assertThat(reader.readAllQuestions())
                .containsExactlyElementsOf(getStandardQuestionList());
    }

    private List<Question> getStandardQuestionList() {
        Question correct = new Question()
                .setId(1)
                .setText("Say my name")
                .setCorrectAnswerIndex("a")
                .addAnswers(List.of(new Answer().setIndex("a").setText("Heisenberg")));
        return List.of(correct);
    }
}