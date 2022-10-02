//Pizza class Address

public class Address{
	private String street;
	private String city;
	private String state;
	private String postcode;
	
	
	public Address(){
		street = "Unknown";
		city = "Unknown";
		state = "Unknown";
		postcode = "Unknown";
	}
	
	public Address(String street, String city, String state, String postcode){
		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
	}
	
	public void setStreet(String street){this.street = street;}
	public void setCity(String city){this.city = city;}
	public void setState(String state){this.state = state;}
	public void setPostcode(String postcode){this.postcode = postcode;}
	
	public String getStreet(String street){return street;}
	public String getCity(String city){return city;}
	public String getState(String state){return state;}
	public String getPostcode(String postcode){return postcode;}
	
	public String toString(){
		return ("Address: " +street+ ", " +city+ ", " +state+ ", " +postcode);
	}
}