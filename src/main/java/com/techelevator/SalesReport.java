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

    public static void loadRunningSalesMap() {
        runningSalesMap = FileIO.loadSalesReport();
        addNewItemsToSalesMap();
        totalSales = FileIO.loadSalesReportTotal();
    }

    public static void addNewItemsToSalesMap(){
        // create a set of the names of the items already in the sales report
        Set<String> salesReportKeys = runningSalesMap.keySet();
        // Load the csv file, generate csvLines
        FileIO.loadCsv();
        // iterate through the item data in csvLines
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

    public static boolean addSale(String itemName) {
        if (!runningSalesMap.keySet().contains(itemName)) return false;
        runningSalesMap.put(itemName, runningSalesMap.get(itemName) + 1);
        return true;
    }

    public static void addTotal(String price) {
        String total = MoneyMath.add(totalSales, price);
        totalSales = total;
    }

    public static int getItemSoldCount(String itemName) {
        if (!runningSalesMap.keySet().contains(itemName)) return -1;
        return runningSalesMap.get(itemName);
    }

    public static void run(){
        if (FileIO.writeSalesReport(false)) Printer.println("\nFile creation success!\n");
        for (String element : runningSalesMap.keySet()){
            Printer.println(element + "|" + runningSalesMap.get(element));
        }
        Printer.newLine();
        Printer.println("Total Sales: $" + totalSales);
    }

    public static String getTotalSales() {
        return totalSales;
    }

    public static void resetFields() {
        totalSales = "0.00";
        runningSalesMap = new HashMap<>();
    }

    public static void setRunningSalesMap(Map<String,Integer> map) {
        runningSalesMap = map;
    }
}
