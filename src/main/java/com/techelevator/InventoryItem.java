package com.techelevator;

import com.techelevator.candy.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryItem {
    //Constructor
    public InventoryItem(String inventoryFilePath) {
        this.filepath = inventoryFilePath;
    }


    //Attributes
    private final String filepath;
    Map<String, Candy> inventory;


    //Getters and Setters


    //Methods
    public Map<String, Candy> inventoryBuilder(String[] candies) {
        inventory = new HashMap<>();

        File inventoryCSV = new File(filepath);

        try (Scanner inventoryScanner = new Scanner(inventoryCSV)) {
            while (inventoryScanner.hasNextLine()) {
                String currentLineFromInventoryScanner = inventoryScanner.nextLine();
                String[] currentLineToArray = currentLineFromInventoryScanner.split("\\|");
                Candy currentItem = null;
                String ID = currentLineToArray[1];
                boolean isWrapped;

                if (currentLineToArray[currentLineToArray.length - 1].equals("T")) {
                    isWrapped = true;
                } else {
                    isWrapped = false;
                }

                int price = Integer.parseInt(currentLineToArray[3]);
                String typeOfCandy = currentLineToArray[0];

                if (typeOfCandy.equalsIgnoreCase("CH")) {
                    currentItem = new ChocolateCandy(ID, currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("SR")) {
                    currentItem = new SourCandy(ID, currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("HC")) {
                    currentItem = new HardCandy(ID, currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("LI")) {
                    currentItem = new LicoriceCandy(ID, currentLineToArray[2], isWrapped, price);
                }
                inventory.put(ID, currentItem);
            }
        } catch(FileNotFoundException e){
            System.out.println("Input file does not exist");
        }
        return inventory;
    }

    public void restockInventory() {
        for (Map.Entry<String, Candy> candy : inventory.entrySet()) {
            if (candy.getValue().getQuantity() < 100) {
                candy.getValue().setQuantity(100);
            }
        }
    }
}

