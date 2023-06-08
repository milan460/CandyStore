package com.techelevator.candy;

public class Candy {


    //Constructor
    public Candy(String ID, String name, boolean isWrapped, int quantity, double price){
        this.ID = ID;
        this.name = name;
        this.isWrapped = isWrapped;
        this.quantity = quantity;
        this.price = price;
    }

    //Attributes
    private String ID;
    private String name;
    private double price;
    private boolean isWrapped;
    private int quantity;


    //Getters and Setters
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWrapped() {
        return isWrapped;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
