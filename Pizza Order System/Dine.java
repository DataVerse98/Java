/Pizza class Delivery

public class Delivery{
	private String delAddress;
	private String cusName;
	private String cusPhone;
	
	public Delivery(){
		delAddress = "Unknown";
	}
	
	public Delivery(String d){
		delAddress = d;
	}
	
	public void setDelivery(String d){
		delAddress = d;
	}
	
	public String getDeliveryAddress(){return delAddress;}
	
	public String toString(){return ("Delivery Address: " +delAddress);}
}