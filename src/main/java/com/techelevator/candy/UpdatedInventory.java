package com.techelevator.candy;

import java.util.Map;

public class UpdatedInventory {

    private Map<String, Candy> inventory;

    public UpdatedInventory(Map<String, Candy> inventory) {
        this.inventory = inventory;
    }

    public void restockInventory() {
        for (Map.Entry<String, Candy> candy : inventory.entrySet()) {
            candy.getValue().setQuantity(100);
        }
    }
}

