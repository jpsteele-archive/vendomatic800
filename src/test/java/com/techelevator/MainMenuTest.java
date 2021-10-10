package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class MainMenuTest {
    MainMenu output = new MainMenu();

    @Test
    public void issue_command_implements_display_items_method_with_input_1(){
        String input = "1";
        boolean actual = MainMenu.issueCommand(input);
        Assert.assertTrue(actual);
    }
//    @Test
//    public void issue_command_implements_purchase_method_with_input_2(){
//        String input = "2";
//        boolean actual = MainMenu.issueCommand(input);
//        Assert.assertTrue(actual);
//    }

    @Test
    public void issue_command_implements_Sales_Report_method_with_input_4(){
        String input = "4";
        boolean actual = MainMenu.issueCommand(input);
        Assert.assertTrue(actual);
    }
    @Test
    public void issue_command_returns_false_if_invalid_selection(){
        String input1 = "10";
        String input2 = "-10";
        String input3 = "0";
        String input4 = "one";
        boolean actual1 = MainMenu.issueCommand(input1);
        boolean actual2 = MainMenu.issueCommand(input2);
        boolean actual3 = MainMenu.issueCommand(input3);
        boolean actual4 = MainMenu.issueCommand(input4);
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
        Assert.assertFalse(actual4);
    }

    @Test
    public void display_items_will_show_sold_out_if_no_stock(){
    /*  my idea for this would be add a few things to the main method that could be checked,
    but that would result in extra lines of code in the method that only needs to run in the test. (Hence didn't do that)
    It would work by the following way: 1) Initialize an empty string 2)in the for each loop if the item has stock,
    it will add the slot key as a string to the initialized string 3)if the for each loop if the item is out, it will
    add a "SO" instead of the key slot to the string 4) you could then check the assert string as to what you expect
    to be in or out of stock as you set it up at the beginning of the test
    */
    }
//    @Test
//    public void issue_command_implements_exit_method_with_input_3(){
//        String input = "3";
//        boolean actual = MainMenu.issueCommand(input);
//        Assert.assertTrue(actual);
//    }


}
