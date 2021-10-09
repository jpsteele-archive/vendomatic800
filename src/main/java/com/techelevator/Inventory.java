package com.techelevator;

import java.util.*;

public class Inventory {
    private static Map<String, List<Item>> inventory = new HashMap<>();

    public static void buildInventory() {
        inventory = new HashMap<>();
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
            inventory.put(element[0], new ArrayList<Item> (List.of(item, item, item, item, item)));
        }
    }

    /**
     * @param name name of the item
     * @return quantity of the item in inventory if it is found. Otherwise returns -1
     */
    public static int getItemQuantity(Item name){
        for (List<Item> itemList : inventory.values()) {
            if (itemList.get(0).getName().equals("name")) {
                return itemList.size();
            }
        }
        return -1;
    }

    public static int getItemQuantity(String slot) {
        if (inventory.keySet().contains(slot)) {
            return inventory.get(slot).size();
        }
        return -1;
    }

    public static void removeItem(String slot){
        inventory.get(slot).remove(0);
    }

    public static Item getItem(String slot){
        List<Item> itemList = inventory.get(slot);
        if (itemList.size() > 0) {
            Item itemToVend = itemList.get(0);
            return itemToVend;
        }
        return null;
    }

    public static void setInventory(Map<String,List<Item>> map) {
        inventory = map;
    }

    public static Map<String, List<Item>> getInventory() {
        return inventory;
    }
}
