package com.techelevator;

import com.techelevator.candy.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public class InventoryItemTest {

    private Inventory inventoryItem;
    Candy candy;

    @Before
    public void setup() {
        inventoryItem = new Inventory("inventoryTest.csv");

    }

    @Test
    public void test_inventory_builder() throws FileNotFoundException {
        //Arrange
        Map<String, Candy> expectedInventory = new TreeMap<>();
        expectedInventory.put("C1", new ChocolateCandy("C1","Chocolate Confectionery","Snuckers Bar", true, 1.35));
        expectedInventory.put("S1", new SourCandy("S1","Sour Flavored Candies","Gummy Ants", false, 1.10));
        expectedInventory.put("H1", new HardCandy("H1", "Hard Tack Confectionery","Jolly Cowboy", true, 2.35));
        expectedInventory.put("L3", new LicoriceCandy("L3", "Licorice and Jellies","Anise Twist", true, 0.90));

        for(Map.Entry<String, Candy> candy : expectedInventory.entrySet()){
            candy.getValue().setQuantity(100);
        }
        //Act
        Map<String, Candy> actualInventory = inventoryItem.inventoryBuilder();
        //Assert
        Assert.assertEquals(expectedInventory, actualInventory);
    }
}



