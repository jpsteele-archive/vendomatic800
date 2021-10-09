package com.techelevator;

public class Gum extends Item{

    public Gum(String name, double price) {
        super(name, price);
    }
    @Override
    public String giveMessage(){
        String gumMessage = "Chew Chew, Yum!";
        Printer.println(gumMessage);
        return gumMessage;
    }
}
