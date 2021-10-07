package com.techelevator;

import java.util.List;

public class MainMenu extends Menu {

    public MainMenu() {
        super();
        addOption("(1) Display Vending Machine Items");
        addOption("(2) Purchase");
        addOption("(3) Exit");

    }

    public void run() {
        while (true) {
            for (String option : getOptions()) {
                Printer.print(option);
            }
            Printer.newLine(1);
            String input = UserInput.get("Please enter your selection");
            issueCommand(input);
        }

    }

    public boolean validateInput(String input) {
        if (input != "1" && input != "2" && input != "3" && input != "4") {
            return false;
        }
        return true;
    }

    public void issueCommand(String input) {
        if (!validateInput(input)) {
            Printer.print("Please enter a valid input.");
            return;
        }
        if (input == "1") {
            displayItems();
            return;
        }
        if (input == "2") {
            purchase();
            return;
        }
        if (input == "3") {
            exit();
        }
        if (input == "4") {
            salesReport();
            return;
        }
    }

    public void displayItems() {

    }

    public void purchase() {
        Purchase.run();
    }

    public void exit() {
        System.exit(0);
    }

    public void salesReport() {

    }
}
