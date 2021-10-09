package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileIO {
    private static File readFile = new File("vendingmachine.csv");
    private static File logFile = new File("Log.txt");
    private static File persistentSalesReportFile = new File("src/main/resources/salesreport.txt");
    private static File salesReportDir = new File("sales_reports/");

    private static List<String[]> csvLines = new ArrayList<>();


    public static void loadCsv() {
        csvLines = new ArrayList<>();
        try (Scanner dataInput = new Scanner(readFile)) {
            while (dataInput.hasNextLine()) {
                csvLines.add(dataInput.nextLine().split("\\|"));
            }
        } catch (FileNotFoundException e) {
            Printer.println("Source file not found!");
        }
    }

    public static List<String[]> getCsvLines() {
        return csvLines;
    }

    public static Map<String,Integer> loadSalesReport() {
        Map<String,Integer> salesReportMap = new HashMap<>();
        try (Scanner reader = new Scanner(persistentSalesReportFile)) {
            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split("\\|");
                if (line.length < 2) continue;
                try {
                    int quantity = Integer.parseInt(line[1]);
                    salesReportMap.put(line[0], quantity);
                } catch (NumberFormatException ignored) {}
            }
        } catch (FileNotFoundException e) {
            return salesReportMap;
        }
        return salesReportMap;
    }

    public static void createNewSalesReport(Item item, int quantity){
        try(PrintWriter append = new PrintWriter(salesReportDir)){
            append.println();
        } catch (Exception e){
            Printer.println("Could not add to Sales Report");
        }
    }
    public static void createRunningSalesReport(Item item, int quantity){
        try(PrintWriter append = new PrintWriter(salesReportDir)){
            Map<String, Integer> temp = new HashMap<>();

        } catch (Exception e){
            Printer.println("Could not add to Sales Report");
        }
    }
    public static void readRunningSalesReport(Item item, int quantity){
        try(PrintWriter append = new PrintWriter(salesReportDir)){
            append.println();
        } catch (Exception e){
            Printer.println("Could not add to Sales Report");
        }
    }

    /**
     * @param action keyword String for the action being taken
     * @param leftAmount first monetary value
     * @param rightAmount second monetary value
     */
    public static void appendLog(String action, String leftAmount, String rightAmount) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.println(dateTime.format(format) + " " + action + " $" + leftAmount + " " + rightAmount);
        } catch (FileNotFoundException e) {
            Printer.println("Couldn't write to log file!");
        }
    }

}
