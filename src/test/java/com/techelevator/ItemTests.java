package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTests {
    private Item item;
    private Chip chip;
    private Drink drink;
    private Candy candy;
    private Gum gum;

    @Before
    public void startUp() {
        item = new Item("Generic Item", 1.00);
        chip = new Chip("Crunchy Taters", 1.50);
        drink = new Drink("Slurpy Freezer", 2.50);
        candy = new Candy("Chewy Chewers", 1.75);
        gum = new Gum("Bubble Bomb", 0.75);
    }

    @Test
    public void giveMessage_returns_appropriate_message() {
        String result1 = item.giveMessage();
        String result2 = chip.giveMessage();
        String result3 = drink.giveMessage();
        String result4 = candy.giveMessage();
        String result5 = gum.giveMessage();

        String expected1 = "";
        String expected2 = "Crunch Crunch, Yum!";
        String expected3 = "Glug Glug, Yum!";
        String expected4 = "Munch Munch, Yum!";
        String expected5 = "Chew Chew, Yum!";

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);
        Assert.assertEquals(expected5, result5);
    }

    @Test
    public void name_and_price_getters_work() {
        String name1 = item.getName();
        String name2 = chip.getName();
        String name3 = drink.getName();
        String name4 = candy.getName();
        String name5 = gum.getName();

        String expectedName1 = "Generic Item";
        String expectedName2 = "Crunchy Taters";
        String expectedName3 = "Slurpy Freezer";
        String expectedName4 = "Chewy Chewers";
        String expectedName5 = "Bubble Bomb";

        double price1 = item.getPrice();
        double price2 = chip.getPrice();
        double price3 = drink.getPrice();
        double price4 = candy.getPrice();
        double price5 = gum.getPrice();

        double expectedPrice1 = 1.00;
        double expectedPrice2 = 1.50;
        double expectedPrice3 = 2.50;
        double expectedPrice4 = 1.75;
        double expectedPrice5 = 0.75;

        Assert.assertEquals(expectedName1, name1);
        Assert.assertEquals(expectedName2, name2);
        Assert.assertEquals(expectedName3, name3);
        Assert.assertEquals(expectedName4, name4);
        Assert.assertEquals(expectedName5, name5);
        Assert.assertEquals(expectedPrice1, price1, 0);
        Assert.assertEquals(expectedPrice2, price2, 0);
        Assert.assertEquals(expectedPrice3, price3, 0);
        Assert.assertEquals(expectedPrice4, price4, 0);
        Assert.assertEquals(expectedPrice5, price5, 0);

    }
}
