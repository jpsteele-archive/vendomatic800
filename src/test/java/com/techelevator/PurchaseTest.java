package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseTest {
    Purchase test = new Purchase();

    @Before
    public void reset_balance() {
        test.resetBalance();
    }

    @Test
    public void basic_test_run(){

    }

    @Test
    public void basic_test_issue_command(){

    }

    @Test
    public void basic_test_feed_money(){

    }

    @Test
    public void basic_test_is_valid_int(){

    }

    @Test
    public void basic_test_add_to_balance(){

    }

    @Test
    public void basic_test_is_valid_key_slot(){
        String input = "A1";
        boolean actual = Purchase.isValidKeySlot(input);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void basic_test_vend_product(){

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
//    @Test
//<<<<<<< HEAD
//    public void test_make_change_dimes_at_40(){ // This shows that the method isn't giving us any dimes
//        Purchase.addToBalance(19.35);
//        double input = Purchase.getBalance();
////=======
//    public void test_make_change_not_all_quarters(){ // This shows that the method isn't giving us any dimes
//        Purchase.addToBalance("0.65");
//        String input = Purchase.getBalance();
////>>>>>>> ad45853e37159185d27b866b1076d50e3a5ee98a
//        test.makeChange();
//    }
}
