package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport {
    private static double totalSales = 0.0;
    private static Map<String, Integer> runningSalesMap = new HashMap<>();

    /*
    on startup: load runningSalesMap from persistentFile, check FileIO.getCsvLines() for new items
    on sale: update runningSalesMap and overwrite persistentFile
    on main menu option 4: write new file in salesReportDir
     */

    public static void loadRunningSalesMap() {
        runningSalesMap = FileIO.loadSalesReport();
    }

    public void createRunningSalesMap(){
        List<String[]> listOfItems = FileIO.getCsvLines();
        for (String[] element : listOfItems){

            String itemName = element[1];
            runningSalesMap.put(itemName, 0);
        }
    }

    public static Map<String, Integer> getRunningSalesMap() {
        return runningSalesMap;
    }

    // add to sales number

    // add to total


    public static double getTotalSales() {
        return totalSales;
    }
}
