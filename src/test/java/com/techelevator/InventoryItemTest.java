package com.techelevator;

import com.techelevator.candy.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InventoryItemTest {
    private InventoryItem inventoryItem;

    @Before
    public void setup(){
        inventoryItem = new InventoryItem("inventoryTest.csv");
    }

    @Test
    public void test_inventory_builder(){
        //Arrange
        Map<String, Candy> expectedInventory = new HashMap<>();
        expectedInventory.put("C1", new ChocolateCandy("C1", "Snuckers Bar", true, 1.35));
        expectedInventory.put("S1", new SourCandy("S1", "Gummy Ants", false, 0.10));
        expectedInventory.put("H1", new HardCandy("H1", "Jolly Cowboy", true, 2.35));
        expectedInventory.put("L3", new LicoriceCandy("L3", "Anise Twist", true, 0.90));
        //Act
        Map<String, Candy> actualInventory = inventoryItem.inventoryBuilder();
        //Assert
        Assert.assertEquals(expectedInventory, actualInventory);
    }
}
