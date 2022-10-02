//Pizza class Order
import java.io.*;

public abstract class Order{
	private int orderNo;
	private String orderType;
	
	protected String date;
	protected String payment;
	protected int quantity;
	protected Pizza pizza;
	
	public Order(){
		orderNo = 0;
		orderType = "Unknown";
		date = "Unknown";
		payment = "Unknown";
		quantity = 0;
		pizza = null;
		
	}
	
	public Order(int i, /*String t,*/ String d, String p, int q, Pizza pz){
		orderNo = i;
		//orderType = t;
		date = d;
		payment = p;
		quantity = q;
		pizza = pz;
	}
	
	/*public void setOrder(String i, String t, String d, int q){
		orderNo = i;
		orderType = t;
		date = d;
		quantity = q;
	}*/
	public void setOrderNo(int o){orderNo = o;}
	//public void setOrderType(String ot){orderType = ot;}
	public void setDate(String d){date = d;}
	public void setQuantity(int q){quantity = q;}
	
	public void setPayment(String p){payment = p;}
	
	public int getOrderID(){return orderNo;}
	//public String getOrderType(){return orderType;}
	public String getOrderDate(){return date;}
	public int getOrderQuantity(){return quantity;}
	public String getPaymentType(){return payment;}
	
	public double calcPrice(){
		double price = 0;
		price = pizza.getPizzaPrice() * quantity;
		return price;
	}
	//cash or card
	public void setPaymentType(String payment){this.payment = payment;}
	
	//display payment
	public abstract void calcTotalPayment(double totprice, PrintWriter pw);  //double totprice, String payment
	
	public boolean cancleOrder(){
		if(quantity < 1)
			return true;
		else
			return false;
	}
	
	public void displayOrder(PrintWriter pw){
		System.out.println("\t"+quantity+"\t"+pizza.toString()+"\t"+calcPrice());
		pw.println("\t"+quantity+"\t"+pizza.toString()+"\t"+calcPrice());
	}
	
	public void display(){
		System.out.println("Order No: " +orderNo);
		//System.out.println("Order Type: " +orderNo);
		System.out.println("Date: " +date);
		System.out.println("Order Quantity: " +quantity);
		System.out.println("Payment Method: " + payment);
		System.out.println("Price: " +calcPrice());
		//System.out.println("Total: " +calcTotalPayment(calcPrice()));
	}
}