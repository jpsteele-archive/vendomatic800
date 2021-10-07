package com.techelevator;

import java.util.List;

public class MainMenu {
    private static List<String> options = List.of(
            "(1) Display Vending Machine Items",
            "(2) Purchase",
            "(3) Exit");

    public static void run() {
        while (true) {
            Printer.newLine();
            for (String option : options) {
                Printer.println(option);
            }
            Printer.newLine();
            String input = UserInput.get("Please enter your selection: ");
            issueCommand(input);
        }

    }

    public static boolean validateInput(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
            return false;
        }
        return true;
    }

    public static void issueCommand(String input) {
        if (!validateInput(input)) {
            Printer.print("\nPlease enter a valid input.\n");
            return;
        }
        if (input.equals("1")) {
            displayItems();
            return;
        }
        if (input.equals("2")) {
            purchase();
            return;
        }
        if (input.equals("3")) exit();

        if (input.equals("4")) {
            salesReport();
            return;
        }
    }

    public static void displayItems() {

    }

    public static void purchase() {
        Purchase.run();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void salesReport() {

    }
}
