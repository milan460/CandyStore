package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Money;
import com.techelevator.candy.Candy;

import java.util.*;

public class Menu {

    //Attributes
    private Money money = new Money();
    private Scanner userInput = new Scanner(System.in);


    //Methods
    public String mainMenu() {

        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");
        System.out.println("Choose menu option: ");
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
            if (candyEntry.getValue().isWrapped() == true) {
                wrapped = "Y";
            }

            if (candyEntry.getValue().getQuantity() == 0) {
                soldOut = "SOLD OUT";
            }
            Candy candy = candyEntry.getValue();
            System.out.printf("%-10S %-20s %-10s %-10d $%-5.2f\n", candy.getID(), candy.getName(), wrapped, candy.getQuantity(), candy.getPrice());
        }
        System.out.println("");
    }


    public String subMenu() {
        System.out.println("(1) Take Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Sale");
        System.out.printf("Current Customer Balance: $%-5.2f", money.getBalance());
        System.out.println("\nChoose menu option: ");
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
        while (true) {
            System.out.println("Enter desired $ amount (Max $100 per entry): ");
            String userChoice = userInput.nextLine();
            double amount = Double.parseDouble(userChoice);
            if (amount <= 100) {
                money.addMoney(amount);
                break;
            } else {
                System.out.println("Amount input exceeds $100 please try again");
            }
        }

    }

    public void promptUserSelect(Map<String, Candy> inventory) {
        while (true) {
            System.out.println("Which candy would you like to buy? Enter candy ID: ");
            String userChoice = userInput.nextLine();

            for (Map.Entry<String, Candy> userEntry : inventory.entrySet()) {

                    if (userEntry.getValue().getID() != userChoice) {
                        System.out.println("Does not match candy ID, please try again: ");
                        break;

                    } else if (userEntry.getValue().getQuantity() == 0) {
                        System.out.println("I'm sorry, but that item is SOLD OUT, please make another selection: ");
                        break;

                    } else if (userEntry.getValue().getID() == userChoice)
                        System.out.println("Please select quantity for candy selected: ");
                        userChoice = userInput.nextLine();
                        break;
                    }
            }
        }
    }

//    public List<String> getUserCartSelections(String choice) {
//        List<String> cartSkus = new ArrayList<>();
//        while(choice.equalsIgnoreCase("purchase")){
//            // make a purchase
//            displayMessage("Please enter the sku of the item you wish to purchase or enter x when finished: ");
//            String skuSelected = getUserInput();
//            if(skuSelected.equalsIgnoreCase("x")){
//                break;
//            }
//            //add sku selected to list of skus
//            cartSkus.add(skuSelected);
//        }
//        return cartSkus;
//    }
//}


