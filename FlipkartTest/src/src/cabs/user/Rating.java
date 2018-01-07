package src.cabs.user;

public class Rating {

	String toId;
	String fromId;
	String fromUserType;
	Integer rating;
	
	public Rating(String toId,String fromId,String fromUserType,Integer rating) {
		this.toId=toId;
		this.fromId=fromId;
		this.fromUserType=fromUserType;
		this.rating=rating;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getFromUserType() {
		return fromUserType;
	}
	public void setFromUserType(String fromUserType) {
		this.fromUserType = fromUserType;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
