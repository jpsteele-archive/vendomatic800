package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private static Map<String, List<Item>> inventory = new HashMap<>();

    public static void buildInventory() {
        
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
