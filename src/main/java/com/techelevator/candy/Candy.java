package com.techelevator.candy;

import java.util.Objects;

public class Candy {
    //Attributes
    private String ID;
    private String name;
    private double price;
    private boolean isWrapped;
    private int quantity;


    //Constructor
    public Candy(String ID, String name, boolean isWrapped, double price){
        this.ID = ID;
        this.name = name;
        this.isWrapped = isWrapped;
        this.price = price;
    }


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


    @Override
    public String toString() {
        return "Candy{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isWrapped=" + isWrapped +
                ", quantity=" + quantity +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;
        Candy candy = (Candy) o;
        return Double.compare(candy.price, price) == 0 && isWrapped == candy.isWrapped && quantity == candy.quantity && Objects.equals(ID, candy.ID) && Objects.equals(name, candy.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(ID, name, price, isWrapped, quantity);
    }
}
