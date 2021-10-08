package com.techelevator;

import java.util.List;

public class Purchase {
    private static List<String> options = List.of(
            "(1) Feed Money",
            "(2) Select Product",
            "(3) Finish Transaction");

    public static void run() {
        while (true) {
            Printer.newLine();
            for (String option: options) {
                Printer.println(option);
            }
            Printer.newLine();
            String input = UserInput.get("Please enter your selection: ");
            //issueCommand(input);
        }
    }

    public static void issueCommand(String input) {
//        if (input.equals("1")) feedMoney();
//        else if (input.equals("2")) vendProduct();
//        else if (input.equals("3")) makeChange();
//        else Printer.println("Please enter a valid input\n");
    }



}