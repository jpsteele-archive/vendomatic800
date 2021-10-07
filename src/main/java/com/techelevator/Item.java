package com.techelevator;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String giveMessage() {
        return "Please enter an item";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
