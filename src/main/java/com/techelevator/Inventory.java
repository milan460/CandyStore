package com.techelevator;

import com.techelevator.candy.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {

    //Attributes
    private final String filepath;
    Map<String, Candy> inventory;


    //Constructor
    public Inventory(String inventoryFilePath) {
        this.filepath = inventoryFilePath;
    }


    //Methods
    public Map<String, Candy> inventoryBuilder() throws FileNotFoundException {
        inventory = new TreeMap<>();

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

                double price = Double.parseDouble(currentLineToArray[3]);
                String typeOfCandy = currentLineToArray[0];

                if (typeOfCandy.equalsIgnoreCase("CH")) {
                    currentItem = new ChocolateCandy(ID, "Chocolate Confectionery", currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("SR")) {
                    currentItem = new SourCandy(ID, "Sour Flavored Candies",currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("HC")) {
                    currentItem = new HardCandy(ID,"Hard Tack Confectionery" ,currentLineToArray[2], isWrapped, price);

                } else if (typeOfCandy.equalsIgnoreCase("LI")) {
                    currentItem = new LicoriceCandy(ID, "Licorice and Jellies" ,currentLineToArray[2], isWrapped, price);
                }
                currentItem.setQuantity(100);
                inventory.put(ID, currentItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file does not exist");
        }
        return inventory;
    }
}
