//Project class Customer

public class Customer{
	private String cusName;
	private String cusPhone;
	private int cusId;
	
	public Customer(){
		cusName = "Unknown";
		cusPhone = "Unknown";
		cusId = 0;
	}
	
	public Customer(String n, String p, int i){
		cusName = n;
		cusPhone = p;
		cusId = i;
	}
	
	public void setCusName(String n){cusName = n;}
	public void setCusPhone(String p){cusPhone = p;}
	public void setCusId(int i){cusId = i;}
	
	public String getCusName(){return cusName;}
	public String getCusPhone(){return cusPhone;}
	public int getCusId(){return cusId;}
	
	public String toString(){
		return ("No Id: " +cusId+ "\nName: "+cusName+ "\nContact No: " +cusPhone);
	}
}//end class