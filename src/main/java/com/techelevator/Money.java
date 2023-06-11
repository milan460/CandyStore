package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class Money {

    //Attributes
    private double balance;
    private double totalChange;
    private final double TWENTIES = 20.0;
    private final double TENS = 10.0;
    private final double ONES = 1.0;
    private final double QUARTERS = 0.25;
    private final double DIMES = 0.10;
    private final double NICKELS = 0.05;


    //Getters and Setters
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public double getTotalChange() {
        return totalChange;
    }

    //Method
    public void addMoney(double amount) {
        do {
            if (amount <= 100 && balance + amount <= 1000) {
                balance = balance + amount;
                break;
            }
        }
        while (balance <= 1000 && balance + amount <= 1000);

    }



    public Map<String, Integer> giveChange() {

        Map<String, Integer> billCounter = new TreeMap<>();

        List<Double> bills = new ArrayList<>();
        bills.add(TWENTIES);
        bills.add(TENS);
        bills.add(ONES);
        bills.add(QUARTERS);
        bills.add(DIMES);
        bills.add(NICKELS);

        balance = Math.round(balance * 100.0) / 100.0;

        for(int i = 0; i < bills.size(); i++){

            if(balance == 0.00){
                break;
            }
            double bill = bills.get(i);
            int counter = 0;


            while(balance >= bill){
                balance = Math.round((balance - bill) * 100.0) / 100.0;
                counter++;
            }

            if(bill == TWENTIES){
                billCounter.put("Twenty(s)", counter);
                totalChange += (TWENTIES * counter);
            }
            else if(bill == TENS){
                billCounter.put("Ten(s)", counter);
                totalChange += (TENS * counter);
            }
            else if(bill == ONES){
                billCounter.put("One(s)", counter);
                totalChange += (ONES * counter);
            }
            else if(bill == QUARTERS){
                billCounter.put("Quarter(s)", counter);
                totalChange += (QUARTERS * counter);
            }
            else if(bill == DIMES){
                billCounter.put("Dime(s)", counter);
                totalChange += (DIMES * counter);
            }
            else if(bill == NICKELS){
                billCounter.put("Nickel(s)", counter);
                totalChange += (NICKELS * 20);
            }

        }

        return billCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Double.compare(money.balance, balance) == 0 && Double.compare(money.totalChange, totalChange) == 0 && Double.compare(money.TWENTIES, TWENTIES) == 0 && Double.compare(money.TENS, TENS) == 0 && Double.compare(money.ONES, ONES) == 0 && Double.compare(money.QUARTERS, QUARTERS) == 0 && Double.compare(money.DIMES, DIMES) == 0 && Double.compare(money.NICKELS, NICKELS) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, totalChange, TWENTIES, TENS, ONES, QUARTERS, DIMES, NICKELS);
    }
}
