package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class Money {

    //Attributes
    private double balance;
    private final double TWENTIES = 20.0;
    private final double TENS = 10.0;
    private final double FIVES = 5.0;
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


    //Method
    public void addMoney(double amount) {
        do {
            if (amount <= 100 && balance + amount <= 1000) {
                balance = balance + amount;
                break;
            }
        }
        while (balance <= 1000 && balance + amount <= 1000);


//        if(amount <= 100 && balance <= 1000){
//            while (balance <= 1000) {
//                balance += amount;
//                break;
//            }
//        }
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
//        Collections.sort(bills);
        for(int i = 0; i < bills.size(); i++){
            double bill = bills.get(i);
            int counter = 0;
            double coinBalance = (balance % 10) * 100;
            double dollarBalance = Math.floor(balance);
            while(dollarBalance >= bill){
                dollarBalance = dollarBalance - bill;
                counter++;
            }
            if(bill == TWENTIES){
                billCounter.put("Twenty(s)", counter);
            }
            else if(bill == TENS){
                billCounter.put("Ten(s)", counter);
            }
            else if(bill == ONES){
                billCounter.put("One(s)", counter);
            }
            else if(bill == QUARTERS){
                billCounter.put("Quarter(s)", counter);
            }
            else if(bill == DIMES){
                billCounter.put("Dime(s)", counter);
            }
            else if(bill == NICKELS){
                billCounter.put("Nickel(s)", counter);
            }

        }
        return billCounter;
//        if (balance >= TWENTIES){
//            twentyCounter++;
//        }
//        else if (balance >= TENS){
//            tenCounter++;
//        }
//        else if (balance >= FIVES){
//            fiveCounter++;
//        }
//        else if (balance >= ONES){
//            oneCounter++;
//        }
//        else if (balance >= QUARTERS){
//            quarterCounter++;
//        }
//        else if (balance >= DIMES){
//            dimeCounter++;
//        }
//        else if (balance >= NICKELS){
//            nickelCounter++;
//        }
    }
}
