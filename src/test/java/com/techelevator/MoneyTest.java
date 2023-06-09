package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
