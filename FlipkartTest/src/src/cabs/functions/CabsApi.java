package src.cabs.functions;
/*
 * FIND CABS FOR A BOOKING
 * Problem Statement:
 * 
 * You have been given list of trips which driver and customer have completed. At the end of the trip
 * driver has given a rating to the customer and customer has given a rating to the driver as well.
 * Ratings can be 1 to 5. With 5 being a good rating and 1 being bad rating.
 * 
 * Given a customer name, based on the historical trips you need to find the eligible cabs to the
 * customer.
 * 
 * Here are the rules for choosing the eligible cabs
 * 1) The average rating of the cab driver should be equal or higher than the average rating of
 * 	  the customer
 * 2) If there are no matching drivers available for criteria #1 then you may consider drivers
 *    with whom the customer has rode before
 * 3) If the customer had rated a driver with 1 star then the driver is not eligible for the booking
 * 	  and vice verse
 * 
 * Given a customer name
 * 1) Print average rating of the customer
 * 2) Print eligible driver names with their average rating
 * 
 * Bonus question:
 * 1) Driver can go offline as well. Consider eligible drivers with those who are available
 *    online
 * 2) Unit test the code
 * 
 * Sample Data
 * 
 * Driver's Name	Driver's rating		Customer's Name		Customer's rating
 * d1				4					c1					5
 * d1				5					c1					4
 * d1				1					c1					2
 * d2				5					c2					1
 * d2				5					c2					5
 * d2				4					c2					5
 * d3				3					c3					2
 * d3				4					c3					5
 * d3				3					c3					3
 * 
 * **/
import java.util.ArrayList;

import src.cabs.cities.CityData;
import src.cabs.user.Driver;

public interface CabsApi {

	public Double getAverageCustomerRating(String customerId);
	public Double getAverageDriverRating(String driverId);
	public CityData getData();
	public void printDriverDetails(String driverId);
	public boolean addCusDriverData(String driverName,Integer driverRating,String cusName,Integer cusRating);
	public ArrayList<Driver> getEligibleDrivers(String customerId);
	public void printEligibleDrivers(String customerId);
}
