package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {

    // file open, one line at a time
    // create list of arrays
    List<String[]> list = new ArrayList<>();
    Map<String, Item> inventory = new HashMap<>();
public void bla() {
    // build inventory
    for (String[] arr : list) {
        Item item;
        if (arr[3] == "Drink") {
            item = new Drink(arr[1], arr[2]);
        }
    else if (arr[3] == "Chips") {
            item = new Chip(arr[1], arr[2]);
        }
    else {
        item = new Gum(arr[1], arr[2]);
        }
        inventory.put(arr[0], item);
    }

}


}
