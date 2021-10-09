package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        Map<String, List<Item>> inventory = Inventory.getInventory();
        Item item;
        List<Item> items;
        int size;
        List<String> keys = new ArrayList<>();
        for (String slot : inventory.keySet()) {
            keys.add(slot);
        }
        Collections.sort(keys);
        Printer.newLine();
        Printer.println("Current Inventory:");
        for (String slot : keys) {
            items = inventory.get(slot);
            size = items.size();
            if (size > 0) {
                item = items.get(0);
                Printer.println(slot + ": " + item.getName() + ", $" + item.getPrice() + ", stock: " + size);
            } else {
                Printer.println(slot + ": Empty!");
            }
        }
    }

    public static void purchase() {
        Purchase.run();
    }

    public static void exit() {
        FileIO.writeSalesReport(true);
        System.exit(0);
    }

    public static void salesReport() {
        SalesReport.run();
    }
}
