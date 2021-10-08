package com.techelevator;

import java.util.List;

public class Purchase {
    private static double balance = 0.0;

    private static List<String> options = List.of(
            "(1) Feed Money",
            "(2) Select Product",
            "(3) Finish Transaction");


    /*
    When a purchase is made:
        remove item from inventory
        add entry to log
        increment item number in sales report
        add to total in sales report
     */


    public static void run() {
        while (true) {
            Printer.newLine();
            for (String option: options) {
                Printer.println(option);
            }
            Printer.newLine();
            Printer.println("Current balance: " + getBalance());
            Printer.newLine();
            String input = UserInput.get("Please enter your selection: ");
            issueCommand(input);
        }
    }

    public static void issueCommand(String input) {
        if (input.equals("1")) feedMoney();
//        else if (input.equals("2")) vendProduct();
//        else if (input.equals("3")) makeChange();
        else Printer.println("Please enter a valid input\n");
    }

    public static void feedMoney() {
        Printer.newLine();
        String input = UserInput.get("Please feed money now (accepts whole numbers): ");
        if (isValidInt(input)) {
            addToBalance(Double.parseDouble(input));
        } else {
            Printer.newLine();
            Printer.println("Please enter a valid positive whole number.\n");
        }
    }

    public static boolean isValidInt(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void addToBalance(double amount) {
        balance += amount;
    }

    public static double getBalance() {
        return balance;
    }

}