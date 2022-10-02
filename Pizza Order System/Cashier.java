//Pizza class Cashier

public class Cashier{
	private int cashId;
	private String cashName;
	
	public Cashier(){
		cashId = 0;
		cashName = "Unknown";
	}
	
	public Cashier(int i, String n){
		cashId = i;
		cashName = n;
	}
	public void setCashier(int i,String n ){
	cashId = i;
	cashName = n;}
	
	public int getCashierId(){return cashId;}
	public String getCashierName(){return cashName;}
	
	public String toString(){
		return ("Cashier ID: " +cashId+ "\nCashier Name: " +cashName);
	}
}