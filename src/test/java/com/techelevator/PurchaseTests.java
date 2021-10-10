package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseTests {
    Purchase test = new Purchase();

    /*
    test cases:
    issueCommand rejects invalid inputs - DONE
    isValidInt returns appropriate boolean - DONE
    addToBalance appropriately changes the balance - DONE
    isValidKeySlot returns appropriate boolean - DONE
    makeChange returns appropriate String
    debit returns the appropriate boolean - DONE
    debit appropriately changes balance - DONE
     */

    @Before
    public void reset_balance() {
        test.resetBalance();
    }

    @Test
    public void isValidKeySlot_returns_appropriate_boolean(){
        FileIO.loadCsv();
        Inventory.buildInventory();

        // pass valid entry - should be true
        boolean result1 = Purchase.isValidKeySlot("A1");
        // pass invalid entry - should be false
        boolean result2 = Purchase.isValidKeySlot("Hi Walt");

        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void issueCommand_rejects_invalid_inputs() {
        // pass invalid inputs
        boolean result1 = Purchase.issueCommand("4");
        boolean result2 = Purchase.issueCommand("Hi Tom");
        boolean result3 = Purchase.issueCommand("-1");

        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertFalse(result3);
    }

    @Test
    public void issuCommand_returns_true_upon_success() {
        boolean result = Purchase.issueCommand("3");
        Assert.assertTrue(result);
    }

    @Test
    public void isValidInt_returns_appropriate_boolean() {
        // should be true
        boolean result1 = Purchase.isValidInt("1");
        boolean result2 = Purchase.isValidInt("10");
        // should be false
        boolean result3 = Purchase.isValidInt("abc");
        boolean result4 = Purchase.isValidInt("-1");

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertFalse(result4);
    }

    @Test
    public void addToBalance_appropriately_adds_given_amount_to_balance() {
        // test initial balance format
        String result1 = Purchase.getBalance();
        String expected1 = "0.00";
        // test adding whole amount
        Purchase.addToBalance("1.00");
        String result2 = Purchase.getBalance();
        String expected2 = "1.00";
        // test adding a large number that needs to be rounded to even
        Purchase.addToBalance("57.485");
        String result3 = Purchase.getBalance();
        String expected3 = "58.48";

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
    }

    @Test
    public void debit_returns_appropriate_boolean() {
        Purchase.addToBalance("20.00");
        boolean result1 = Purchase.debit("2.00");
        boolean result2 = Purchase.debit("7.50");
        boolean result3 = Purchase.debit("5.50");
        boolean result4 = Purchase.debit("7.75");

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);
    }

    @Test
    public void debit_appropriately_changes_balance() {
        Purchase.addToBalance("20.00");
        Purchase.debit("2.00");
        String result1 = Purchase.getBalance();
        String expected1 = "18.00";
        Purchase.debit("7.50");
        String result2 = Purchase.getBalance();
        String expected2 = "10.50";
        Purchase.debit("5.505");
        String result3 = Purchase.getBalance();
        String expected3 = "5.00";
        Purchase.debit("7.75");
        String result4 = Purchase.getBalance();
        String expected4 = "5.00";

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);
    }

    @Test
    public void makeChange_returns_appropriate_string() {
        Purchase.addToBalance("0.40");
        String result1 = Purchase.makeChange();
        String expected1 = "Your change is $0.40 dispensed in 1 quarter, 1 dime, and 1 nickel. Thank you for your business!";
        Purchase.addToBalance("0.70");
        String result2 = Purchase.makeChange();
        String expected2 = "Your change is $0.70 dispensed in 2 quarters, 2 dimes, and 0 nickels. Thank you for your business!";
        Purchase.addToBalance("0.00");
        String result3 = Purchase.makeChange();
        String expected3 = "Your change is $0.00 dispensed in 0 quarters, 0 dimes, and 0 nickels. Thank you for your business!";
        Purchase.addToBalance("0.05");
        String result4 = Purchase.makeChange();
        String expected4 = "Your change is $0.05 dispensed in 0 quarters, 0 dimes, and 1 nickel. Thank you for your business!";

        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);
        Assert.assertEquals(expected4, result4);

    }

    @Test
    public void makeChange_sets_balance_to_0() {
        Purchase.addToBalance("100.00");
        Purchase.makeChange();
        String result1 = Purchase.getBalance();
        Purchase.addToBalance("5.40");
        Purchase.makeChange();
        String result2 = Purchase.getBalance();
        String expected = "0.00";

        Assert.assertEquals(expected, result1);
        Assert.assertEquals(expected, result2);
    }
}