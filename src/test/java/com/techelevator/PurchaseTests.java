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
    debit returns the appropriate boolean
    debit appropriately changes balance
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
    public void basic_test_make_change(){ //shows that with a basic full integer it works
        Purchase.addToBalance("1.0");
        String input = Purchase.getBalance();
        test.makeChange();
    }

    @Test
    public void test_make_change_negative_number(){ // Right now this is still giving an output when it probs shouldnt
        Purchase.addToBalance("-1.0");
        String input = Purchase.getBalance();
        test.makeChange();
    }
    @Test
    public void test_make_change_dimes_at_40(){
        Purchase.addToBalance("19.35");
        String input = Purchase.getBalance();
        // somehow this test got chopped in a merge or something
    }
}