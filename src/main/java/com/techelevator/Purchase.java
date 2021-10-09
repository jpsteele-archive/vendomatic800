package com.techelevator;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchase {
    private static String balance = MoneyMath.format("0");

    private static List<String> options = List.of(
            "(1) Feed Money",
            "(2) Select Product",
            "(3) Finish Transaction");
    private static boolean loop;


    public static void run() {
        loop = true;
        while (loop) {
            Printer.newLine();
            for (String option: options) {
                Printer.println(option);
            }
            Printer.newLine();
            Printer.println("Current balance: $" + getBalance());
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
        String input = UserInput.get("Please feed money now (accepts whole numbers): $");
        if (isValidInt(input)) {
            addToBalance(input);
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

    public static void addToBalance(String amount) {
        balance = MoneyMath.add(balance, amount);
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
            Printer.newLine();
            input = UserInput.get("Please enter your selection: ");
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
        String itemPrice = String.valueOf(itemToVend.getPrice());
        String balanceBefore = getBalance();
        if (!debit(itemPrice)) {
            Printer.println("Insufficient funds! Please feed more money.");
            return;
        }
        Inventory.removeItem(input);
        FileIO.appendLog(itemName, balanceBefore, getBalance());
        SalesReport.addToSalesReportMap(itemName);
        SalesReport.addToTotal(itemToVend.getPrice());
        Printer.println("Thank you for your purchase!");
    }

    public static void makeChange() {
        String initialBalance = getBalance();
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (Double.parseDouble(balance) > 0.00) {
            if (Double.parseDouble(balance) >= 0.25) {
                balance = MoneyMath.subtract(balance, "0.25");
                quarters++;
            } else if (Double.parseDouble(balance) >= 0.10) {
                balance = MoneyMath.subtract(balance, "0.10");
                dimes++;
            } else {
                balance = MoneyMath.subtract(balance, "0.05");
                nickels++;
            }
        }
        Printer.newLine();
        Printer.println("Your change is $" + initialBalance + " dispensed in " + quarters + " quarters, " + dimes
                + " dimes, and " + nickels + " nickels. Thank you for your business!");
        loop = false;
    }

    public static String getBalance() {
        return balance;
    }

    public String resetBalance() {
        balance = "0.00";
        return balance;
    }

    public static boolean debit(String price) {
        if (Double.parseDouble(balance) > Double.parseDouble(price)) {
            balance = MoneyMath.subtract(balance, String.valueOf(price));
            return true;
        }
        else return false;
    }

}