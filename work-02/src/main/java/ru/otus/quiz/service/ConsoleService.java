package ru.otus.quiz.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleService {
    private final PrintWriter pw;
    private final Scanner scanner;

    public ConsoleService(OutputStream out, InputStream in) {
        this.pw = new PrintWriter(out);
        this.scanner = new Scanner(in);
    }

    public void printf(String msg, Object... args) {
        pw.printf(msg, args);
        pw.flush();
    }

    public String read() {
        return scanner.next();
    }
}
