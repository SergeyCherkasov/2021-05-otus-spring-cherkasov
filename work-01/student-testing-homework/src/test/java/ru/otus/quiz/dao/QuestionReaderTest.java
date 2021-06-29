package ru.otus.quiz.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import ru.otus.quiz.domain.Question;
import ru.otus.quiz.exceptions.QuestionSourceReadException;

import java.util.List;

class QuestionReaderTest {
    private final static String NOT_EXISTING_FILE = "notexist";
    private final static String INVALID_FILE = "invalidQuestion.csv";
    private final static String VALID_FILE = "validQuestion.csv";

    @Test
    void testMissingFileException() {
        Throwable e = assertThrows(QuestionSourceReadException.class, () -> {
            QuestionReader questionReader = new QuestionReaderCsvImpl(NOT_EXISTING_FILE);
            questionReader.readAllQuestions();
        });
        assertEquals("Missing or empty question csv file", e.getMessage());
    }

    @Test
    void  testInvalidFileException() {
        Throwable e = assertThrows(QuestionSourceReadException.class, () -> {
            QuestionReader questionReader = new QuestionReaderCsvImpl(INVALID_FILE);
            questionReader.readAllQuestions();
        });
        assertEquals("Error read question csv file", e.getMessage());
    }

    @Test
    void testSuccessfulFileRead() throws QuestionSourceReadException {
        QuestionReader reader = new QuestionReaderCsvImpl(VALID_FILE);
        List<Question> questions = reader.readAllQuestions();
        assertEquals(1, questions.size());
        Question question = questions.get(0);
        assertEquals(1, question.getId());
        assertEquals("Say my name", question.getText());
        assertEquals(1, question.getAnswers().size());
        assertEquals("Heisenberg", question.getAnswers().get("a"));
    }
}