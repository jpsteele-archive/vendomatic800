package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private static Map<String, List<Item>> inventory = new HashMap<>();

    public static void buildInventory() {
        List<String[]> temp = FileIO.getCsvLines();
        for (String[] element : temp) {
            Item item = null;
            if (element[3] == "Drink") {
                item = new Drink(element[1], Double.parseDouble(element[2]));
            } else if (element[3] == "Chips") {
                item = new Chip(element[1], Double.parseDouble(element[2]));
            } else if (element[3] == "Candy"){
                item = new Candy(element[1], Double.parseDouble(element[2]));
            } else if (element[3] == "Gum"){
                item = new Gum(element[1], Double.parseDouble(element[2]));
            }
            inventory.put(element[0], List.of(item, item, item, item, item));
        }
    }
    public static int getItemQuantity(Item name){
        int quantity = inventory.get(name).size();
        return quantity;
    }
    public static Item removeItem(Item name){
        inventory.get(name).remove(name);
        return name;
    }

    public static Map<String, List<Item>> getInventory() {
        return inventory;
    }
}
