package ru.otus.quiz.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.quiz.domain.Student;

@Service
@Data
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final ConsoleService console;

    @Override
    public Student introduceStudent() {
        Student student = new Student();
        console.printf("Please enter your name: ");
        student.setFirstName(console.read());
        console.printf("Please enter your surname: ");
        student.setLastName(console.read());
        return student;
    }
}
