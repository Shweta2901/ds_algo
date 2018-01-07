package src.cabs.user;

import java.util.ArrayList;

public class Driver extends User{
	
	public Driver(String userName, String id,String fromId,Integer rating) {
		// TODO Auto-generated constructor stub
		super(userName, id);
		Rating newRating =new Rating(id,fromId,"Customer",rating);
		if(customerRatings==null) {
			customerRatings= new ArrayList<Rating>();
		}
		customerRatings.add(newRating);
	}

	ArrayList<Rating> customerRatings;

	public ArrayList<Rating> getCustomerRatings() {
		return customerRatings;
	}

	public void setCustomerRatings(ArrayList<Rating> customerRatings) {
		this.customerRatings = customerRatings;
	}

}
