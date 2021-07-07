package ru.otus.quiz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.quiz.service.QuizService;

@ComponentScan
@Configuration
public class Application {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        QuizService quizService = ctx.getBean(QuizService.class);
        quizService.runQuiz();
    }
}
