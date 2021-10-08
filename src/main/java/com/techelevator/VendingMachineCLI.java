package com.techelevator;

import java.util.List;

public class VendingMachineCLI {

	public static void main(String[] args) {
		FileIO.load();
		FileIO.appendLog("FEED MONEY", 5.00, 10.00);
		Inventory.buildInventory();
		// build sales report
		MainMenu.run();


//		FileIO.load();
//		System.out.println(FileIO.getCsvLines().get(4)[1]);
//
		FileIO.appendLog("FEED MONEY", 5.00, 10.00);

	}
}
