package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SalesReportTests {
    private Map<String,Integer> salesMap;

    @Before
    public void startUp() {
        SalesReport.resetFields();

        salesMap = new HashMap<>(Map.of(
                "item1", 0,
                "item2", 1,
                "item3", 2,
                "item4", 3,
                "item5", 4));
    }

    /*
    test cases:
    addSale
    addTotal (will also test getTotalSales)
    addNewItemsToSalesMap
    loadRunningSalesMap
     */

    @Test
    public void addSale_increments_amt_sold() {
        SalesReport.setRunningSalesMap(salesMap);

        int before = SalesReport.getRunningSalesMap().get("item3");
        int expectedBefore = 2;
        SalesReport.addSale("item3");
        int after = SalesReport.getRunningSalesMap().get("item3");
        int expectedAfter = 3;

        Assert.assertEquals(expectedBefore, before);
        Assert.assertEquals(expectedAfter, after);
    }

    @Test
    public void addTotal_adds_given_amount_to_totalSales() {
        String before = SalesReport.getTotalSales();
        String expectedBefore = "0.00";
        SalesReport.addTotal("1.25");
        String after1 = SalesReport.getTotalSales();
        String expectedAfter1 = "1.25";
        SalesReport.addTotal("5.50");
        String after2 = SalesReport.getTotalSales();
        String expectedAfter2 = "6.75";

        Assert.assertEquals(expectedBefore, before);
        Assert.assertEquals(expectedAfter1, after1);
        Assert.assertEquals(expectedAfter2, after2);
    }

    @Test
    public void addNewItemsToSalesMap_correctly_adds_items_with_0_sold() {
        SalesReport.setRunningSalesMap(salesMap);

        int result1 = SalesReport.getItemSoldCount("Dr. Salt");
        int expected1 = -1;

        SalesReport.addNewItemsToSalesMap();

        int result2 = SalesReport.getItemSoldCount("Dr. Salt");
        int expected2 = 0;

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }
}