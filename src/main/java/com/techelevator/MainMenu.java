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

    public static void issueCommand(String input) {
        if (input.equals("1")) displayItems();
        else if (input.equals("2")) purchase();
        else if (input.equals("3")) exit();
        else if (input.equals("4")) salesReport();
        else Printer.println("\nPlease enter a valid input");
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
