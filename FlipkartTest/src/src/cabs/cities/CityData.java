package src.cabs.cities;

import java.util.ArrayList;
import java.util.HashMap;

import src.cabs.user.Customer;
import src.cabs.user.Driver;

public class CityData {
	
	public static CityData instance;

	HashMap<Integer,ArrayList<Driver>> ratingDriverMap;
	HashMap<Integer,ArrayList<Customer>> ratingCustomerMap;
	HashMap<String,Driver> drivers;
	HashMap<String,Customer> customers;
	
	private CityData() {
		ratingDriverMap= new HashMap<Integer,ArrayList<Driver>>();
		ratingCustomerMap = new HashMap<Integer,ArrayList<Customer>>();
		drivers = new HashMap<String,Driver>();
		customers = new HashMap<String,Customer>();
	}
	public static CityData getInstance() {
		if(instance == null) {
			instance = new CityData();
		}
		return instance;
	}
	
	public HashMap<Integer, ArrayList<Driver>> getRatingDriverMap() {
		return ratingDriverMap;
	}
	public void setRatingDriverMap(HashMap<Integer, ArrayList<Driver>> ratingDriverMap) {
		this.ratingDriverMap = ratingDriverMap;
	}
	public HashMap<Integer, ArrayList<Customer>> getRatingCustomerMap() {
		return ratingCustomerMap;
	}
	public void setRatingCustomerMap(HashMap<Integer, ArrayList<Customer>> ratingCustomerMap) {
		this.ratingCustomerMap = ratingCustomerMap;
	}
	public HashMap<String, Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(HashMap<String, Driver> drivers) {
		this.drivers = drivers;
	}
	public HashMap<String, Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(HashMap<String, Customer> customers) {
		this.customers = customers;
	}
}
