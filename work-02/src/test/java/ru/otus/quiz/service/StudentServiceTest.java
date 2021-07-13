package ru.otus.quiz.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.quiz.Application;
import ru.otus.quiz.domain.Student;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Application.class)
@TestPropertySource("classpath:application-test.properties")
class StudentServiceTest {
    private final static String DEFAULT_NAME = "Sergey";
    private final static String DEFAULT_LAST_NAME = "Cherkasov";
    @Autowired
    private StudentService studentService;
    @MockBean
    private InputOutputServiceImpl consoleMock;

    @Test
    public void testIntroduce() {
        Mockito.when(consoleMock.read()).thenReturn(DEFAULT_NAME, DEFAULT_LAST_NAME);
        Student expectingStudent = new Student().setFirstName(DEFAULT_NAME).setLastName(DEFAULT_LAST_NAME);
        Assertions.assertThat(studentService.introduceStudent()).isEqualTo(expectingStudent);
    }
}