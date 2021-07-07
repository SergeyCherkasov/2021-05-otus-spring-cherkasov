package ru.otus.quiz.dao;

import org.springframework.util.StringUtils;
import ru.otus.quiz.domain.Question;
import ru.otus.quiz.exceptions.QuestionSourceReadException;

import java.io.InputStream;
import java.util.*;

public class QuestionReaderCsvImpl implements QuestionReader {
    private final static String DELIMITER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    private final String csvPath;

    public QuestionReaderCsvImpl(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<Question> readAllQuestions() throws QuestionSourceReadException {
        InputStream csvIs = getClass().getClassLoader().getResourceAsStream(csvPath);
        if(csvIs == null) {
            throw new QuestionSourceReadException("Missing or empty question csv file");
        }
        Map<Integer, Question> questionMap = new HashMap<>();
        try (Scanner scanner = new Scanner(csvIs);) {
            while (scanner.hasNextLine()) {
                String[] rowData = scanner.nextLine().split(DELIMITER, -1);
                Integer id = Integer.valueOf(rowData[0]);
                Question question = questionMap.get(id);
                if(question == null) {
                    question = new Question()
                            .setId(id)
                            .setText(rowData[1].replace("\"", ""))
                            .setAnswers(new HashMap<>());
                    questionMap.put(id, question);
                }
                question.getAnswers().put(rowData[2], rowData[3]);
                if(StringUtils.hasText(rowData[4])) {
                    question.setCorrectAnswerIndex(rowData[2]);
                }
            }
        } catch (Exception e) {
            throw new QuestionSourceReadException("Error read question csv file", e);
        }
        return new ArrayList<>(questionMap.values());
    }
}
