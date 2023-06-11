package com.techelevator.view;

import com.techelevator.candy.Candy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public ShoppingCart(){

    }
    public ShoppingCart(Candy candy, int quantity, double totalAmount){
        this.candy = candy;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    private Candy candy;
    private int quantity;
    private double totalAmount;

    public Candy getCandy() {
        return candy;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void buildReceipt(Candy candy, int quantity, double totalAmount){

    }

}
