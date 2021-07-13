package ru.otus.quiz.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quiz.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final InputOutputService inputOutputService;

    @Override
    public Student introduceStudent() {
        Student student = new Student();
        inputOutputService.printf("Please enter your name: ");
        student.setFirstName(inputOutputService.read());
        inputOutputService.printf("Please enter your surname: ");
        student.setLastName(inputOutputService.read());
        return student;
    }
}
