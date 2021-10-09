package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SalesReport {
    private static String totalSales;
    private static Map<String, Integer> runningSalesMap = new HashMap<>();

    /*
    on startup: load runningSalesMap from persistentFile, check FileIO.getCsvLines() for new items -- DONE
    on sale: update runningSalesMap and overwrite persistentFile -- DONE
        Need to fill in the method for adding to totalSales -- DONE
        Need a method to overwrite the persistentFile in FileIO given the runningSalesMap and totalSales (check the readme on formatting this)
    on main menu option 4: write new file in salesReportDir -- DONE
        This can use the same method in FileIO as overwriting the persistentFile using a passed boolean maybe?
     */

    public static void loadRunningSalesMap() {
        runningSalesMap = FileIO.loadSalesReport();
        addNewItemsToSalesMap();
        totalSales = FileIO.loadSalesReportTotal();
    }

    public static void addNewItemsToSalesMap(){
        // create a set of the names of the items already in the sales report
        Set<String> salesReportKeys = runningSalesMap.keySet();
        // iterate through the item data in the csv file
        for (String[] element : FileIO.getCsvLines()){
            // set the item name value to a string variable
            String itemName = element[1];
            // check to see if the item already exists in the sales report
            if (salesReportKeys.contains(itemName)) continue;
            // if the item isn't already accounted for, add it with 0 sales
            runningSalesMap.put(itemName, 0);
        }
    }

    public static Map<String, Integer> getRunningSalesMap() {
        return runningSalesMap;
    }

    public static void addSale(String itemName) {
        runningSalesMap.put(itemName, runningSalesMap.get(itemName) + 1);
    }

    public static void addTotal(String price) {
        String total = MoneyMath.add(totalSales, price);
        totalSales = total;
    }

    public static void run(){
        FileIO.writeSalesReport(false);
        for (String element : runningSalesMap.keySet()){
            Printer.println(element + "|" + runningSalesMap.get(element));
        }
        Printer.newLine();
        Printer.println("Total Sales: $" + totalSales);
    }

    public static String getTotalSales() {
        return totalSales;
    }
}
