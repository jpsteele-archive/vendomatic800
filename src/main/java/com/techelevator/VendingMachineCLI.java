package com.techelevator;

public class VendingMachineCLI {

	public static void main(String[] args) {
		FileIO.loadCsv();
		Inventory.buildInventory();
		SalesReport.loadRunningSalesMap();

		MainMenu.run();
	}
}


/*
These classes need work:
Purchase
SalesReport
FileIO

See notes in the classes!
 */