package com.techelevator;

import org.junit.*;

import java.util.*;

public class InventoryTests {
    private Chip chip;
    private Drink drink;
    private Candy candy;
    private Gum gum;
    private Map<String, List<Item>> inventory;

    @Before
    public void startUp () {
        chip = new Chip("Crunchy Taters", 1.50);
        drink = new Drink("Slurpy Freezer", 2.50);
        candy = new Candy("Chewy Chewers", 1.75);
        gum = new Gum("Bubble Bomb", 0.75);
        inventory = Map.of(
                "A0", new ArrayList<>(List.of()),
                "A1", new ArrayList<>(List.of(chip)),
                "A2", new ArrayList<>(List.of(drink, drink)),
                "A3", new ArrayList<>(List.of(candy, candy, candy)),
                "A4", new ArrayList<>(List.of(gum, gum, gum, gum)));
    }

    @Test
    public void buildinventory_creates_map_size_same_as_csvLines() {
        FileIO.loadCsv();
        Inventory.buildInventory();
        int mapSize1 = Inventory.getInventory().size();
        int expected1 = FileIO.getCsvLines().size();
        FileIO.loadCsv();
        Inventory.buildInventory();
        int mapSize2 = Inventory.getInventory().size();
        int expected2 = FileIO.getCsvLines().size();
        Assert.assertEquals(expected1, mapSize1);
        Assert.assertEquals(expected2, mapSize2);
    }

    @Test
    public void buildinventory_content_validation() {
        FileIO.loadCsv();
        Inventory.buildInventory();
        Map<String, List<Item>> inventory = Inventory.getInventory();
        Set<String> names = new HashSet<>();

        for (List<Item> list : inventory.values()) {
            names.add(list.get(0).getName());
        }

        boolean test1 = names.contains("Potato Crisps");
        boolean test2 = names.contains("Stackers");
        boolean test3 = names.contains("Grain Waves");
        boolean test4 = names.contains("Cloud Popcorn");
        boolean test5 = names.contains("Moonpie");
        boolean test6 = names.contains("Cowtales");
        boolean test7 = names.contains("Wonka Bar");
        boolean test8 = names.contains("Crunchie");
        boolean test9 = names.contains("Cola");
        boolean test10 = names.contains("Dr. Salt");
        boolean test11 = names.contains("Mountain Melter");
        boolean test12 = names.contains("Heavy");
        boolean test13 = names.contains("U-Chews");
        boolean test14 = names.contains("Little League Chew");
        boolean test15 = names.contains("Chiclets");
        boolean test16 = names.contains("Triplemint");

        Assert.assertTrue(test1);
        Assert.assertTrue(test2);
        Assert.assertTrue(test3);
        Assert.assertTrue(test4);
        Assert.assertTrue(test5);
        Assert.assertTrue(test6);
        Assert.assertTrue(test7);
        Assert.assertTrue(test8);
        Assert.assertTrue(test9);
        Assert.assertTrue(test10);
        Assert.assertTrue(test11);
        Assert.assertTrue(test12);
        Assert.assertTrue(test13);
        Assert.assertTrue(test14);
        Assert.assertTrue(test15);
        Assert.assertTrue(test16);
    }

    @Test
    public void getItemQuantity_returns_size_of_Item_list_given_slot() {
        Inventory.set(inventory);

        int test1 = Inventory.getItemQuantity("A0");
        int test2 = Inventory.getItemQuantity("A1");
        int test3 = Inventory.getItemQuantity("A2");
        int test4 = Inventory.getItemQuantity("A3");
        int expected1 = 0;
        int expected2 = 1;
        int expected3 = 2;
        int expected4 = 3;

        Assert.assertEquals(test1, expected1);
        Assert.assertEquals(test2, expected2);
        Assert.assertEquals(test3, expected3);
        Assert.assertEquals(test4, expected4);
    }

    @Test
    public void removeItem_removes_an_item() {
        Inventory.set(inventory);

        int expected1 = 4;
        int actual1 = Inventory.getInventory().get("A4").size();
        Inventory.removeItem("A4");
        int expected2 = 3;
        int actual2 = Inventory.getInventory().get("A4").size();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void getItem_returns_an_item_or_null_if_sold_out() {
        Inventory.set(inventory);

        Item result1 = Inventory.getItem("A0");
        Item result2 = Inventory.getItem("A1");
        Item result3 = Inventory.getItem("A2");
        Item result4 = Inventory.getItem("A3");
        Item result5 = Inventory.getItem("A4");

        Item expected1 = null;
        Item expected2 = chip;
        Item expected3 = drink;
        Item expected4 = candy;
        Item expected5 = gum;

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);
        Assert.assertEquals(expected5, result5);
    }
}
