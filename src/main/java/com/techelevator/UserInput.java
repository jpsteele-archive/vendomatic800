package com.techelevator;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @return a string of input provided by the user.
     */
    public static String get() {
        return scanner.nextLine();
    }

    /**
     * @param prompt the prompt to output to the user
     * @return a string of input provided by the user
     */
    public static String get(String prompt) {
        Printer.print(prompt);
        return scanner.nextLine();
    }
}
