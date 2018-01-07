package src.test;

import src.cabs.cities.CityData;
import src.cabs.functions.CabsApi;
import src.cabs.functions.CabsApiImpl;

public class testCabs {

	public static void main(String[] args) {
		CabsApiImpl testObject=new CabsApiImpl();
		CityData data=testObject.getData();
		testObject.addCusDriverData("d1", 4, "c1", 5);
		testObject.addCusDriverData("d1", 5, "c2", 4);
		testObject.addCusDriverData("d1", 1, "c3", 2);
		testObject.addCusDriverData("d2", 5, "c1", 1);
		testObject.addCusDriverData("d2", 5, "c2", 5);
		testObject.addCusDriverData("d2", 4, "c3", 5);
		testObject.addCusDriverData("d3", 3, "c1", 2);
		testObject.addCusDriverData("d3", 4, "c2", 5);
		testObject.addCusDriverData("d3", 3, "c3", 3);
		testObject.addCusDriverData("d4", 1, "c2", 5);
		testObject.addCusDriverData("d4", 1, "c4", 5);
		testObject.addCusDriverData("d4", 1, "c4", 6);
		System.out.println("c1:\t"+testObject.getAverageCustomerRating("c1"));
		System.out.println("c2:\t"+testObject.getAverageCustomerRating("c2"));
		System.out.println("c3:\t"+testObject.getAverageCustomerRating("c3"));
		System.out.println("c4:\t"+testObject.getAverageCustomerRating("c4"));
		
		System.out.println("d1:\t"+testObject.getAverageDriverRating("d1"));
		System.out.println("d2:\t"+testObject.getAverageDriverRating("d2"));
		System.out.println("d3:\t"+testObject.getAverageDriverRating("d3"));
		System.out.println("d4:\t"+testObject.getAverageDriverRating("d4"));
		
		//testObject.printDriverDetails("d1");
		System.out.println("\n"
			
				+ "Eligible Drivers for c2");
		testObject.printEligibleDrivers("c2");
		
		System.out.println("\nEligible Drivers for c2");
		testObject.printEligibleDrivers("c2");
		System.out.println("\nEligible Drivers for c3");
		testObject.printEligibleDrivers("c3");
		System.out.println("\nEligible Drivers for c1");
		testObject.printEligibleDrivers("c1");
		testObject.printEligibleDrivers("c4");
	}
}
