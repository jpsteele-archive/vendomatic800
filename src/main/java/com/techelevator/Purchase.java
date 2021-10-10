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
            Printer.println("Current Money Provided: $" + getBalance());
            Printer.newLine();
            String input = UserInput.get("Please enter your selection: ");
            issueCommand(input);
        }
    }

    public static boolean issueCommand(String input) {
        if (input.equals("1")) feedMoney();
        else if (input.equals("2")) vendProduct();
        else if (input.equals("3")) makeChange();
        else {
            Printer.newLine();
            Printer.println("Please enter a valid input");
            return false;
        }
        return true;
    }

    public static void feedMoney() {
        Printer.newLine();
        String input = UserInput.get("Please feed money now (1, 2, 5, or 10): $");
        if (isValidInt(input) && (input.equals("1") || input.equals("2") || input.equals("5") || input.equals("10"))) {
            addToBalance(input);
            FileIO.appendLog("FEED MONEY:", MoneyMath.format(input), balance);
        } else {
            Printer.newLine();
            Printer.println("Please enter 1, 2, 5, or 10.");
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
        return Inventory.getInventory().containsKey(input);
    }

    public static String vendProduct() {
        String input;
        MainMenu.displayItems();
        Printer.newLine();
        input = UserInput.get("Please enter your selection: ");
        if (!isValidKeySlot(input)) {
            Printer.newLine();
            Printer.println("Input not valid. ");
            return "invalid slot";
        }
        Item itemToVend = Inventory.getItem(input);
        if (itemToVend == null) {
            Printer.println("That slot is SOLD OUT!");
            return "slot sold out";
        }
        String itemName = itemToVend.getName();
        String itemPrice = String.valueOf(itemToVend.getPrice());
        String balanceBefore = getBalance();
        if (!debit(itemPrice)) {
            Printer.newLine();
            Printer.println("Insufficient funds! Please feed more money.");
            return "insufficient funds";
        }
        Inventory.removeItem(input);
        Printer.newLine();
        Printer.println("Here is your " + itemToVend.getName() + "! We have withdrawn $" + MoneyMath.format(String.valueOf(itemToVend.getPrice())) + " from your balance.");
        itemToVend.giveMessage();
        String logName = itemName + " " + input;
        FileIO.appendLog(logName, balanceBefore, getBalance());
        SalesReport.addSale(itemName);
        SalesReport.addTotal(itemPrice);
        Printer.println("Thank you for your purchase!");
        return "success";
    }

    public static String makeChange() {
        String initialBalance = getBalance();
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        String qString = "quarters";
        String dString = "dimes";
        String nString = "nickels";

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
        FileIO.appendLog("GIVE CHANGE:", MoneyMath.format(initialBalance), balance);
        if (quarters == 1) qString = "quarter";
        if (dimes == 1) dString = "dime";
        if (nickels == 1) nString = "nickel";
        Printer.newLine();
        String output = "Your change is $" + initialBalance + " dispensed in " + quarters + " " + qString + ", " + dimes
                + " " + dString + ", and " + nickels + " " + nString + ". Thank you for your business!";
        Printer.println(output);
        loop = false;
        return output;
    }

    public static String getBalance() {
        return balance;
    }

    public String resetBalance() {
        balance = "0.00";
        return balance;
    }

    public static boolean debit(String price) {
        if (Double.parseDouble(balance) >= Double.parseDouble(price)) {
            balance = MoneyMath.subtract(balance, price);
            return true;
        }
        return false;
    }
}