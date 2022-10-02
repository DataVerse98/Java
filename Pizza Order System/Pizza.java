//Project class Pizza

public class Pizza{
	private String pizName;
	private String pizSize;
	private double pizPrice;
	
	public Pizza(){
		pizName = "Unknown";
		pizSize = "XX";
		pizPrice = 0.0;
	}
	
	public Pizza(String n, String s, double p){
		pizName = n;
		pizSize = s;
		pizPrice = p;
	}
	
	public void setPizza(String n, String s, double p){
		pizName = n;
		pizSize = s;
		pizPrice = p;
	}
	
	public String getPizzaName(){return pizName;}
	public String getPizzaSize(){return pizSize;}
	public double getPizzaPrice(){return pizPrice;}
	
	
	public String toString(){
		return (pizName+ "\t" +pizSize+ "\t" +pizPrice);
	}
}