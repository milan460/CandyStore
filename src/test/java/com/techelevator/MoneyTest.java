package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class MoneyTest {
    private Money money;

    @Before
    public void setup(){
        money = new Money();
    }

    @Test
    public void test_addMoney_within_range(){
        //Arrange
        double amount2 = 56;
        //Act
        double actualAmount = money.getBalance();
        //Assert
        Assert.assertNotEquals(amount2, actualAmount);
    }

    @Test
    public void test_addMoney_outside_range(){
        //Arrange
        double amount = 101;
        //Act
        double actualAmount = money.getBalance();
        //Assert
        Assert.assertNotEquals(amount, actualAmount);
    }

    @Test
    public void test_addMoney_total_amount_outside_range(){
        //Arrange
        money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(100);
		money.addMoney(99);
		money.addMoney(1);
		money.addMoney(2);
		double expected = 1000;
        //Act
        double actualAmount = money.getBalance();
        //Assert
        Assert.assertEquals(expected, actualAmount, 0.00);
    }

    @Test
    public void test_giveChange_passing_0(){
        //Arrange
        Map<String, Integer> expected = new TreeMap<>();
        Map<String, Integer> actual = new TreeMap<>();

        expected.put("Twenty(s)", 0);
        expected.put("Ten(s)", 0);
        expected.put("One(s)", 0);
        expected.put("Quarter(s)", 0);
        expected.put("Dime(s)", 0);
        expected.put("Nickel(s)", 0);
        //Act
        actual = money.giveChange();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_giveChange_passing_100(){
        //Arrange
        Map<String, Integer> expected = new TreeMap<>();
        Map<String, Integer> actual = new TreeMap<>();
        money.setBalance(100);
        expected.put("Twenty(s)", 5);
        expected.put("Ten(s)", 0);
        expected.put("One(s)", 0);
        expected.put("Quarter(s)", 0);
        expected.put("Dime(s)", 0);
        expected.put("Nickel(s)", 0);
        //Act
        actual = money.giveChange();
        //Assert
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_giveChange_passing_thirty_one_dollars_and_fourty_cents(){
        //Arrange
        Map<String, Integer> expected = new TreeMap<>();
        Map<String, Integer> actual = new TreeMap<>();
        money.setBalance(31.40);
        expected.put("Twenty(s)", 1);
        expected.put("Ten(s)", 1);
        expected.put("One(s)", 1);
        expected.put("Quarter(s)", 1);
        expected.put("Dime(s)", 1);
        expected.put("Nickel(s)", 1);
        //Act
        actual = money.giveChange();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_giveChange_passing_1000(){
        //Arrange
        Map<String, Integer> expected = new TreeMap<>();
        Map<String, Integer> actual = new TreeMap<>();
        money.setBalance(1000);
        expected.put("Twenty(s)", 50);
        expected.put("Ten(s)", 0);
        expected.put("One(s)", 0);
        expected.put("Quarter(s)", 0);
        expected.put("Dime(s)", 0);
        expected.put("Nickel(s)", 0);
        //Act
        actual = money.giveChange();
        //Assert
        Assert.assertEquals(expected, actual);
    }


}
