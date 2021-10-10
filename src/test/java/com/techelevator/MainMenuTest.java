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
        MainMenu.issueCommand(input);
        //not done
    }
    @Test
    public void issue_command_implements_purchase_method_with_input_2(){
        String input = "2";
        MainMenu.issueCommand(input);
        // not done
    }
    @Test
    public void issue_command_implements_exit_method_with_input_3(){
        String input = "3";
        MainMenu.issueCommand(input);
        // not done
    }

    @Test
    public void issue_command_implements_Sales_Report_method_with_input_4(){
        String input = "4";
        MainMenu.issueCommand(input);
        // not done
    }

    @Test
    public void display_items_will_show_sold_out_if_no_stock(){

    }



}
