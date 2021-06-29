package ru.otus.quiz;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.quiz.service.QuizService;

public class Application {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        quizService.printAllQuestions();
        context.close();
    }
}
