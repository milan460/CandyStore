package com.techelevator;

public class Money {

    //Attributes
    private double balance;
    private final double TWENTIES = 20.00;
    private final double TENS = 10.00;
    private final double FIVES = 5.00;
    private final double ONES = 1.00;
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



//    public void giveChange() {
//        double changeGiven = balance - ;
//        if (balance >= TWENTIES){
//
//        }
//    }
}
