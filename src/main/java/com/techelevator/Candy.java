package com.techelevator;

public class Candy extends Item{

    public Candy(String name, double price) {
        super(name, price);
    }
    @Override
    public String giveMessage(){
        String candyMessage = "Munch Munch, Yum!";
        return candyMessage;
    }
}