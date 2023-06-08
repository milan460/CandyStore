package com.techelevator;

import com.techelevator.candy.Candy;

import java.util.HashMap;
import java.util.Map;

public class InventoryItem {
    //Constructor
    //Attributes
    Map<String, Candy> inventory;
    //Getters and Setters
    //Methods
    public Map<String, Candy> inventoryBuilder(String[] candies){
        inventory = new HashMap<>();

        Candy chocolate = new Candy("A1", "chocolate", false, 3, 3.00);

        inventory.put("A1", chocolate);
        return inventory;
    }

    public void restockInventory(){
        for(Map.Entry<String,Candy> candy : inventory.entrySet()) {
            if (candy.getValue().getQuantity() < 100) {
                candy.getValue().setQuantity(100);
            }
        }
    }


}
