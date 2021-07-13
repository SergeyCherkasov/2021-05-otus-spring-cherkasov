package ru.otus.quiz.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputServiceImpl implements InputOutputService {
    private final PrintWriter pw;
    private final Scanner scanner;

    public InputOutputServiceImpl(OutputStream out, InputStream in) {
        this.pw = new PrintWriter(out);
        this.scanner = new Scanner(in);
    }

    @Override
    public void printf(String msg, Object... args) {
        pw.printf(msg, args);
        pw.flush();
    }

    @Override
    public String read() {
        return scanner.next();
    }
}
