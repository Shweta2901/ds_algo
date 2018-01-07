package src.cabs.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import src.cabs.cities.CityData;
import src.cabs.user.Customer;
import src.cabs.user.Driver;
import src.cabs.user.Rating;

public class CabsUtility {

	public Customer getCustomer(String customerId) {
		CityData data = CityData.getInstance();
		return data.getCustomers().get(customerId);
	}

	public Driver getDriver(String driverId) {
		CityData data = CityData.getInstance();
		return data.getDrivers().get(driverId);
	}

	public Double getAverageCusRating(String customerId) {
		// if customer is not valid/not present in the data return -1
		Customer customer = getCustomer(customerId);
		if (customer == null) {
			return null;
		}
		ArrayList<Rating> ratings = customer.getDriverRatings();
		Integer averageRating = new Integer(0);
		for (Rating rating : ratings) {
			averageRating += rating.getRating();
		}
		// if customer has ride once...asssuming he will have atleast one entry
		// in rating
		return (averageRating > 0) ? (double) averageRating / (double) ratings.size() : null;
	}

	public Double getAverageDriverRating(String driverId) {
		// if driver is not valid/not present in the data return -1
		Driver driver = getDriver(driverId);
		if (driver == null) {
			return null;
		}
		ArrayList<Rating> ratings = driver.getCustomerRatings();
		Integer averageRating = new Integer(0);
		for (Rating rating : ratings) {
			averageRating += rating.getRating();
		}
		// if driver has ride once...asssuming he will have atleast one entry in
		// rating
		return (averageRating > 0) ? (double) averageRating / (double) ratings.size() : null;

	}

	public boolean addCustomerDriverData(String cusName, String cusId, Integer cusRating, String driverName,
			String driverId, Integer driverRating) {
		// add customer
		// if customer already exists add rating data to it
		CityData data = CityData.getInstance();
		Customer customer = data.getCustomers().get(cusId);
		// if this is first time customer rode, add en entry
		if (customer == null) {
			customer = new Customer(cusName, cusId, driverId, cusRating);
			// add entry to city data
			data.getCustomers().put(cusId, customer);
		} else {
			Rating newRating = new Rating(cusId, driverId, "Driver", cusRating);
			customer.getDriverRatings().add(newRating);
		}

		// add Driver
		// if driver already exists add rating data to it
		Driver driver = data.getDrivers().get(driverId);
		// if this is first time customer rode, add en entry
		if (driver == null) {
			driver = new Driver(driverName, driverId, cusId, driverRating);
			data.getDrivers().put(driverId, driver);
		} else {
			Rating newRating = new Rating(driverId, cusId, "Customer", driverRating);
			driver.getCustomerRatings().add(newRating);
		}

		return true;
	}

	public void printDriverDetails(String driverId) {
		Driver driver = getDriver(driverId);
		if(driver==null) {
			System.out.println("Invalid Driver Id");
			return;
		}
		System.out.println("DriverName:"+driver.getUserName());
		System.out.println("DriverId:"+driver.getId());
		Double rating = getAverageDriverRating(driverId);
		if(rating!=null)
			System.out.println("Average Rating:"+rating);
		else
			System.out.println("Average Rating:"+0);
	}
	
	public ArrayList<Driver> getDriversOfHigherRating(Customer customer) {
		if(customer == null)
			return null;
		ArrayList<Driver> driverList=new ArrayList<Driver>();
		Double avgCustomerRating = getAverageCusRating(customer.getId());
		if(avgCustomerRating!=null) {
			CityData data = CityData.getInstance();
			// get data of all drivers
			HashMap<String,Driver> alldrivers = data.getDrivers();
			for (Map.Entry<String, Driver> entry : alldrivers.entrySet()) {
			    String driverId = entry.getKey();
			    Driver driver = entry.getValue();
			    Double avgDriverRating = getAverageDriverRating(driverId);
			    if(avgDriverRating!=null) {
			    	if(avgDriverRating>=avgCustomerRating) {
			    		driverList.add(driver);
			    	}
			    }
			}
		} else {
			return null;
		}
		return driverList;
	}
}
