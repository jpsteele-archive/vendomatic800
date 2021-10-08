package com.techelevator;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport {
    private double total = 0.0;
    private Map<String, Integer> runningSalesMap = new HashMap<>();

    public void createRunningSalesMap(){
        List<String[]> listOfItems = FileIO.getCsvLines();
        for (String[] element : listOfItems){

            String itemName = element[1];
            runningSalesMap.put(itemName, 0);
        }
    }

    public Map<String, Integer> getRunningSalesMap() {
        return runningSalesMap;
    }

    // add to sales number

    // add to total


    public double getTotal() {
        return total;
    }
}
