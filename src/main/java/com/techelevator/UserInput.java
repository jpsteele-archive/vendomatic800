package com.techelevator;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String get(String prompt) {
        Printer.print(prompt);
        return scanner.nextLine();
    }
}
