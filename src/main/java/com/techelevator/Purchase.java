package com.techelevator;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchase {
    private static double balance = 0.0;

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
            Printer.println("Current balance: " + getBalance());
            Printer.newLine();
            String input = UserInput.get("Please enter your selection: ");
            issueCommand(input);
        }
    }

    public static void issueCommand(String input) {
        if (input.equals("1")) feedMoney();
        else if (input.equals("2")) vendProduct();
        else if (input.equals("3")) makeChange();
        else {
            Printer.newLine();
            Printer.println("Please enter a valid input");
        }
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

    public static boolean isValidKeySlot(String input) {
        boolean isvalid = false;
        for (String element : Inventory.getInventory().keySet()) {
            if (input.equals(element)) {
                isvalid = true;
            }
        }
        return isvalid;
    }

    public static void vendProduct() {
        String input;
        MainMenu.displayItems();
        while (true) {
            input = UserInput.get("Please enter your selection:");
            if (!isValidKeySlot(input)) {
                Printer.println("Input not valid. ");
                continue;
            }
            break;
        }
        Item itemToVend = Inventory.getItem(input);
        if (itemToVend == null) {
            Printer.println("That slot is empty!");
            return;
        }
        String itemName = itemToVend.getName();
        double itemPrice = itemToVend.getPrice();
        double balanceBefore = getBalance();
        if (!debit(itemPrice)) {
            Printer.println("Insufficient funds! Please feed more money.");
            return;
        }
        Inventory.removeItem(input);
        FileIO.appendLog(itemName, balanceBefore, getBalance());
        // increment sales report
        // add to total in sales report
        Printer.println("Thank you for your purchase!");
    }

    public static void makeChange() {
        double initialBalance = getBalance();
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (balance > 0) {
            if (balance >= 0.25) {
                balance -= 0.25;
                quarters++;
            } else if (balance >= 10) {
                balance -= 0.10;
                dimes++;
            } else {
                balance -= 0.05;
                nickels++;
            }
        }

        Printer.newLine();
        Printer.println("Your change is " + initialBalance + " dispensed in " + quarters + " quarters, " + dimes
                + " dimes, and " + nickels + " nickels. Thank you for your business!\n");
    }

    public static double getBalance() {
        return balance;
    }

<<<<<<< HEAD
    public double resetBalance() {
        this.balance = 0;
        return balance;
=======
    public static boolean debit(double price) {
        if (balance > price) {
            balance -= price;
            return true;
        }
        else return false;
>>>>>>> 9340da7bd6d364c71d00dbce6e7798cda889d0a8
    }

}