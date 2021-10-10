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

    @Test
    public void issue_command_implements_Sales_Report_method_with_input_4(){
        SalesReport.loadRunningSalesMap();
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
}
