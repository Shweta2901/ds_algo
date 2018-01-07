package src.cabs.user;

import java.util.ArrayList;

public class Customer extends User{

	ArrayList<Rating> driverRatings;
	
	public Customer(String name,String id,String fromId,Integer rating) {
		super(name,id);
		Rating newRating =new Rating(id,fromId,"Driver",rating);
		if(driverRatings==null) {
			driverRatings = new ArrayList<Rating>();
		}
		driverRatings.add(newRating);
	}

	public ArrayList<Rating> getDriverRatings() {
		return driverRatings;
	}

	public void setDriverRatings(ArrayList<Rating> driverRatings) {
		this.driverRatings = driverRatings;
	}
	
}
