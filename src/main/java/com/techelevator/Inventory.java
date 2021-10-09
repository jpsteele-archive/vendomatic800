package com.techelevator;

import java.util.*;

public class Inventory {
    private static Map<String, List<Item>> inventory = new HashMap<>();

    public static void buildInventory() {
        List<String[]> temp = FileIO.getCsvLines();
        for (String[] element : temp) {
            Item item = new Item("", 0.0);
            if (element[3].equals("Drink")) {
                item = new Drink(element[1], Double.parseDouble(element[2]));
            } else if (element[3].equals("Chip")) {
                item = new Chip(element[1], Double.parseDouble(element[2]));
            } else if (element[3].equals("Candy")){
                item = new Candy(element[1], Double.parseDouble(element[2]));
            } else if (element[3].equals("Gum")){
                item = new Gum(element[1], Double.parseDouble(element[2]));
            }
            inventory.put(element[0], List.of(item, item, item, item, item));
        }
    }
    public static int getItemQuantity(Item name){
        int quantity = inventory.get(name).size();
        return quantity;
    }
    public static void removeItem(String slot){
        // Instantiate item from inventory
        Item item = inventory.get(slot).get(0);
        // create a new List from which we can remove easier
        List<Item> newList = new ArrayList<>();
        // pull the current list into the new list
        newList = inventory.get(slot);
        // remove one item from the new list
        newList.remove(item);
        // put the new list in place of the old list
        inventory.put(slot, newList);

    }

    public static Item getItem(String slot){
        List<Item> itemList = inventory.get(slot);
        if (itemList.size() > 0) {
            Item itemToVend = itemList.get(0);
            return itemToVend;
        }
        return null;
    }

    public static Map<String, List<Item>> getInventory() {
        return inventory;
    }
}
