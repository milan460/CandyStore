package com.techelevator;

import com.techelevator.candy.Candy;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

public class ApplicationCLI {

	//Attributes
	private Menu menu = new Menu();
	private Map<String, Candy> inventory;


	//Constructor
	public ApplicationCLI(Map<String, Candy> inventory) {
		this.inventory = inventory;
	}


	//Methods
	public static void main(String[] args) {
		Inventory inventoryBuilder = new Inventory("inventory.csv");


		ApplicationCLI cli;
		try {
			cli = new ApplicationCLI(inventoryBuilder.inventoryBuilder());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		cli.run();
	}


	/**
	 * This is the main method that controls the flow of the program.. Probably could look at the review code for ideas of what to put here...
	 */
	public void run() {
		// Good place to create references for UserInterface, Inventory class, and Register class.... (There should NEVER be more than one instance of these)
		//probably a great place to create a loop that manages the main menu and delegates all work to the other classes....
		// Hint: for the submenu, maybe a loop inside this main loop? If you break out of the sub-loop(sub-menu), you would reach the
		//outer loop....
		//feel free to create private methods here if you are feeling up to it, so run() doesn't get so long...


		Money money = new Money();
		while (true) {
			String choice = menu.mainMenu();
			if (choice.equals("display")) {
				menu.displayInventory(inventory);
			} else if (choice.equals("sale")) {
				while(true) {
					String choiceSubmenu = menu.subMenu();
					if (choiceSubmenu.equals("take money")) {
						menu.promptUserAmount();
					}
					else if (choiceSubmenu.equals("select products")) {
						menu.displayInventory(inventory);
						menu.promptUserSelect(inventory);
					}
					else if(choiceSubmenu.equalsIgnoreCase("complete sale")){
						menu.completeSalePrompt();
						break;
					}

				}
			} else if (choice.equals("quit")) {
				System.exit(0);
			}
		}
	}
}



