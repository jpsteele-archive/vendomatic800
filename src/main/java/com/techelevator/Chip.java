package com.techelevator;

public class Chip extends Item{

    public Chip(String name, double price) {
        super(name, price);
    }
    @Override
    public String giveMessage(){
        String chipMessage = "Crunch Crunch, Yum!";
        return chipMessage;
    }
}