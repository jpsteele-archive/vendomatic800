package com.techelevator;

public class Drink extends Item{

    public Drink(String name, double price) {
        super(name, price);
    }
    @Override
    public String giveMessage(){
        String drinkMessage = "Glug Glug, Yum!";
        Printer.println(drinkMessage);
        return drinkMessage;
    }
}
