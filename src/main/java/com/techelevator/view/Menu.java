package com.techelevator.view;

import com.techelevator.Money;
import com.techelevator.ShoppingCart;
import com.techelevator.candy.Candy;
import com.techelevator.filereader.LogFileWriter;

import java.util.*;

public class Menu {

    //Attributes
    private Money money = new Money();
    private Scanner userInput = new Scanner(System.in);
    private List<ShoppingCart> finishedCart = new ArrayList<>();


    //Methods
    public String mainMenu() {

        System.out.println("\n(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");
        System.out.println("\nChoose menu option: ");
        String userChoice = userInput.nextLine();
        String option = userChoice.trim();

        if (option.equalsIgnoreCase("1")) {
            option = "display";
        } else if (option.equalsIgnoreCase("2")) {
            option = "sale";
        } else if (option.equalsIgnoreCase("3")) {
            option = "quit";
        }
        return option;
    }

    public void displayInventory(Map<String, Candy> inventory) {

        System.out.printf("\n%-10s %-20s %-10s %-10s %-10s\n", "Id", "Name", "Wrapper", "Qty", "Price");
        System.out.println("____________________________________________________________\n");

        for (Map.Entry<String, Candy> candyEntry : inventory.entrySet()) {
            String wrapped = "N";
            String soldOut = "";
            Candy candy = candyEntry.getValue();
            if (candyEntry.getValue().isWrapped() == true) {
                wrapped = "Y";
            }

            if (candyEntry.getValue().getQuantity() == 0) {
                soldOut = "SOLD OUT";
                System.out.printf("%-10S %-20s %-10s %-10s $%-5.2f\n", candy.getID(), candy.getName(), wrapped, soldOut, candy.getPrice());
            }
            else {
                System.out.printf("%-10S %-20s %-10s %-10d $%-5.2f\n", candy.getID(), candy.getName(), wrapped, candy.getQuantity(), candy.getPrice());
            }
        }
        System.out.println("");
    }

    public String subMenu() {
        System.out.println("\n(1) Take Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Sale");
        System.out.printf("Current Customer Balance: $%-5.2f\n", money.getBalance());
        System.out.println("Choose menu option: ");
        String userChoice = userInput.nextLine();
        String option = userChoice.trim();

        if (option.equalsIgnoreCase("1")) {
            option = "take money";
        } else if (option.equalsIgnoreCase("2")) {
            option = "select products";
        } else if (option.equalsIgnoreCase("3")) {
            option = "complete sale";
        }
        return option;
    }

    public void promptUserAmount() {
        LogFileWriter logFileWriter = new LogFileWriter();
        while (true) {
            System.out.println("\nEnter desired $ amount (Max $100 per entry, Max $1000 total): ");
            String userChoice = userInput.nextLine();
            double amount = Double.parseDouble(userChoice);
            String action = "MONEY RECEIVED";

            if (amount + money.getBalance() > 1000) {
                System.out.println("\nBalance total exceeds $1000, please try again.");
            }

            if (amount <= 100) {
                money.addMoney(amount);
                logFileWriter.logWriter(action, money.getBalance() - amount, money.getBalance());
                break;

            } else {
                System.out.println("\nAmount input exceeds $100, please try again.");
            }
        }
    }

    public void promptUserSelect(Map<String, Candy> inventory) {
        boolean matchingId = false;
        while (!matchingId) {
            System.out.println("Which candy would you like to buy? Enter candy ID: ");
            String userChoice = userInput.nextLine();
            int quantityChoice;

            for (Map.Entry<String, Candy> userEntry : inventory.entrySet()) {
                if(userEntry.getKey().equals(userChoice)) {

                    if (userEntry.getValue().getQuantity() == 0) {
                        System.out.println("I'm sorry, but that item is SOLD OUT, please make another selection: ");
                        break;
                    }

                    while(true) {
                        matchingId = true;
                        System.out.println("Please select quantity for candy selected: ");
                        userChoice = userInput.nextLine();
                        quantityChoice = Integer.parseInt(userChoice);
                        double totalAmount = 0.00;
                        if(quantityChoice <= userEntry.getValue().getQuantity()) {
                            totalAmount = quantityChoice * userEntry.getValue().getPrice();
                        }

                        if (quantityChoice > userEntry.getValue().getQuantity()) {
                            System.out.println("Store only has '" + userEntry.getValue().getQuantity() + "' left in stock. Please select smaller quantity.");
                        }

                        else if(totalAmount > money.getBalance()){
                            System.out.println("Insufficient Funds. Please add money to your balance or choose another item.");
                            break;
                        }

                        else if(quantityChoice <= userEntry.getValue().getQuantity()){
                            int differenceInQuantity = userEntry.getValue().getQuantity() - quantityChoice;
                            userEntry.getValue().setQuantity(differenceInQuantity);
                            double updatedBalance = money.getBalance() - totalAmount;
                            money.setBalance(updatedBalance);
                            ShoppingCart cartItems = new ShoppingCart(userEntry.getValue(), quantityChoice, totalAmount);
                            finishedCart.add(cartItems);
                            break;
                        }
                    }
                }
            }

            if(!matchingId) {
                    System.out.println("Does not match candy ID, please try again.");
                    System.out.println(" ");
                    break;
            }
        }
    }

    public void completeSalePrompt(){
        LogFileWriter logFileWriter = new LogFileWriter();
        double receiptTotal = 0.0;

        System.out.println("\nRECEIPT: \n");
        System.out.printf("%-15s %-15s %-26s %-9s %-10s\n", "Quantity", "Name", "Description", "Price", "Amount");

        for(int i = 0; i < finishedCart.size(); i++){
            ShoppingCart item = finishedCart.get(i);
            int quantity = item.getQuantity();
            Candy candyItem = item.getCandy();
            double totalAmount = item.getTotalAmount();
            String candyDescription = item.getCandy().getDescription();
            double candyPrice = item.getCandy().getPrice();
            String candyName = item.getCandy() .getName();
            String action = item.getQuantity() + candyName + item.getCandy().getID();
            logFileWriter.logWriter(action, money.getBalance() + totalAmount, money.getBalance());


            receiptTotal += totalAmount;
            System.out.printf("%-15d %-15s %-26s $%-8.2f $%-5.2f\n", quantity, candyName, candyDescription, candyPrice, totalAmount);
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("TOTAL: $%-5.2f\n", receiptTotal);
        System.out.println();
        Map<String, Integer> change = money.giveChange();
        System.out.printf("\nCHANGE: $%-5.2f\n", money.getTotalChange());
        String action = "CHANGE GIVEN";
        logFileWriter.logWriter(action, money.getTotalChange(), money.getBalance());

        for(Map.Entry<String, Integer> bill : change.entrySet()){
            System.out.print(bill.getKey() + " (" + bill.getValue() + ") | ");
        }
        System.out.println("\n");
    }
}




