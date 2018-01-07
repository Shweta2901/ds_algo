package src.cabs.functions;

import java.util.ArrayList;
import java.util.HashSet;

import src.cabs.cities.CityData;
import src.cabs.user.Customer;
import src.cabs.user.Driver;
import src.cabs.user.Rating;

public class CabsApiImpl implements CabsApi{

	@Override
	public Double getAverageCustomerRating(String customerId) {
		// TODO Auto-generated method stub
		CabsUtility utility = new CabsUtility();
		Double rating=utility.getAverageCusRating(customerId);
		return (rating!=null)?rating:0;
	}

	@Override
	public CityData getData() {
		// TODO Auto-generated method stub
		CityData data=CityData.getInstance();
		return data;
	}

	@Override
	public boolean addCusDriverData(String driverName, Integer driverRating, String cusName, Integer cusRating) {
		// TODO Auto-generated method stub
		CabsUtility utility = new CabsUtility();
		return utility.addCustomerDriverData(cusName, cusName, cusRating, driverName, driverName, driverRating);
	}

	@Override
	public void printDriverDetails(String driverId) {
		// TODO Auto-generated method stub
		CabsUtility utility = new CabsUtility();
		utility.printDriverDetails(driverId);
	}

	@Override
	public ArrayList<Driver> getEligibleDrivers(String customerId) {
		// TODO Auto-generated method stub
		CabsUtility utility = new CabsUtility();
		
		//if we don't have such customer...throw exception
		Customer customer=utility.getCustomer(customerId);
		if(customer==null) {
			System.out.println("Invalid Customer Id");
			return null;
		}
		//get average rating of this customer
		Double cusRating= getAverageCustomerRating(customerId);
		
		//Criteria1: get all the Drivers whose average rating is higher than this customer
		ArrayList<Driver> driverList=utility.getDriversOfHigherRating(customer);
		
		//Criteria 2: if there are no drivers with criteria 1 get drivers with whom customer travelled earlier
		if(driverList == null || driverList.isEmpty()) {
			if(driverList==null) {
				driverList= new ArrayList<Driver>();
			}
			HashSet<String> driverIds= new HashSet<String>();
			for(Rating rating:customer.getDriverRatings()) {
				driverIds.add(rating.getFromId());
			}
			for(String driverId: driverIds) {
				driverList.add(utility.getDriver(driverId));
			}
		}
		
		//Criteria3: remove driver who was rated 1 or who rated customer 1
		//remove drivers who gave rating 1 to customer
		HashSet<String> removeDriverIds= new HashSet<String>();
		for(Rating rating:customer.getDriverRatings()) {
			if(rating.getRating()==1)
				removeDriverIds.add(rating.getFromId());
		}
		//remove drivers who were rated 1 by this customer
		for(Driver driverOb:driverList) {
			ArrayList<Rating> customerRatings=driverOb.getCustomerRatings();
			for(Rating customerRating: customerRatings) {
				if(customerRating.getFromId().equals(customerId) && customerRating.getRating()==1) {
					removeDriverIds.add(customerRating.getToId());
				}
			}
		}
		ArrayList<Integer> driverIndexes = new ArrayList<Integer>();
		for(int driverIndex=0;driverIndex<driverList.size();driverIndex++) {
			if(removeDriverIds.contains((driverList.get(driverIndex)).getId())) {
				driverIndexes.add(driverIndex);
			}
		}
		for(int index:driverIndexes) {
			driverList.remove(index);
		}
		return driverList;
	}

	@Override
	public void printEligibleDrivers(String customerId) {
		// TODO Auto-generated method stub
		ArrayList<Driver> eligibleDriverList = getEligibleDrivers(customerId);
		if(eligibleDriverList!=null && !eligibleDriverList.isEmpty()) {
			for(Driver driver:eligibleDriverList) {
				printDriverDetails(driver.getId());
			}
		} else {
			System.out.println("No Eligible Drivers");
		}
		return;
	}

	@Override
	public Double getAverageDriverRating(String driverId) {
		// TODO Auto-generated method stub
		CabsUtility utility = new CabsUtility();
		Double rating=utility.getAverageDriverRating(driverId);
		return (rating!=null)?rating:0;
	}

}
