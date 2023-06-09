package com.techelevator;

import com.techelevator.candy.Candy;
import com.techelevator.view.Menu;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;

public class ApplicationCLI {

	// probably should leave this method alone... and go do stuff in the run method....
	public static void main(String[] args) {
//		ApplicationCLI cli = new ApplicationCLI();
//		cli.run();
//		Money money = new Money();
//
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(100);
//		money.addMoney(99);
//		money.addMoney(1);
//		money.addMoney(1);
//		System.out.println(money.getBalance());

		InventoryItem inventoryItem = new InventoryItem("inventory.csv");
		Map<String, Candy> candyMap = new HashMap<>();
		candyMap = inventoryItem.inventoryBuilder();
//		inventoryItem.restockInventory();
//		for (Map.Entry<String, Candy> candy : candyMap.entrySet()) {
//			System.out.println(candy.getValue().getQuantity());
//		}

		Menu menu = new Menu();
		menu.displayInventory(candyMap);

	}

	/**
	 * This is the main method that controls the flow of the program.. Probably could look at the review code for ideas of what to put here...
	 */
	public void run() {


		// Good place to create references for UserInterface, Inventory class, and Register class.... (There should NEVER be more than one instance of these)


		//probably a great place to create a loop that manages the main menu and delegates all work to the other classes....
		// Hint: for the submenu, maybe a loop inside this main loop? If you break out of the sub-loop(sub-menu), you would reach the
		//outer loop....

	}

	//feel free to create private methods here if you are feeling up to it, so run() doesn't get so long...


}
