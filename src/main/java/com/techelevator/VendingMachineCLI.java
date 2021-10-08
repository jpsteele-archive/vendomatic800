package com.techelevator;

public class VendingMachineCLI {

	public static void main(String[] args) {
		FileIO.loadCsv();
		Inventory.buildInventory();
		SalesReport.loadRunningSalesMap();

//		for (String key : SalesReport.getRunningSalesMap().keySet()) {
//			System.out.println(key + " " + SalesReport.getRunningSalesMap().get(key));
//		}

		MainMenu.run();


//		FileIO.load();
//		System.out.println(FileIO.getCsvLines().get(4)[1]);
//

	}
}
