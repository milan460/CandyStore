package com.techelevator.view;

import com.techelevator.candy.Candy;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Scanner userInput = new Scanner(System.in);
    public String mainMenu(){

        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");
        String userChoice = userInput.nextLine();
        String option = userChoice.trim();
        if(option.equalsIgnoreCase("1")){
            option = "display";
        }
        else if (option.equalsIgnoreCase("2")){
            option = "sale";
        }
        else if (option.equalsIgnoreCase("3")){
            option = "quit";
        }
        return option;
    }

    public void displayInventory(Map<String, Candy> inventory){

        System.out.printf("\n%-10s %-20s %-10s %-10s %-10s\n", "Id", "Name", "Wrapper", "Qty", "Price");
        System.out.println("____________________________________________________________\n");

        for(Map.Entry<String, Candy> candyEntry : inventory.entrySet()){
            String wrapped = "N";
            String soldOut = "";
            if(candyEntry.getValue().isWrapped() == true){
                wrapped = "Y";
            }
            if(candyEntry.getValue().getQuantity() == 0){
                soldOut = "SOLD OUT";
            }
            Candy candy = candyEntry.getValue();
            System.out.printf("%-10S %-20s %-10s %-10d $%-5.2f\n",candy.getID(), candy.getName(), wrapped, candy.getQuantity(), candy.getPrice());
        }
    }


}
