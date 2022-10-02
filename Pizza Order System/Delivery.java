//Pizza class Delivery

import javax.swing.*;
import java.text.*;
import java.io.*;

public class Delivery extends Order{
	private double deliveryNo;
	public Customer deliveryCus;
	private Address deliveryAdd;
	
	public Delivery(){
		super();
		deliveryNo = 0;
		deliveryCus = null;
		deliveryAdd = null;
	}
	
	public Delivery(int i, /*String t,*/ String d, String p, int q, Pizza pz, double deliveryNo, Customer c, Address a){
		super(i,d,p,q,pz);
		this.deliveryNo = deliveryNo;
		deliveryCus = c;
		deliveryAdd = a;
	}
	
	public void setDeliveryNo(double d){deliveryNo = d;}
	public void setDeliveryCustomer(Customer c){deliveryCus = c;}
	public void setDeliveryAddress(Address a){deliveryAdd = a;}
	
	public double getDeliveryNo(){return deliveryNo;}
	public Customer getDeliveryCustomer(){return deliveryCus;}
	public Address getDeliveryAddress(){return deliveryAdd;}
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void calcTotalPayment(double totprice, PrintWriter pw){  //String pymt
		String pymt = getPaymentType();
		double addFee = 5.00;
		double tax = 0.06;
		double payment,tax_payment;
		if(pymt.equalsIgnoreCase("Cash")){
			tax_payment = tax * totprice;
			payment = totprice + tax_payment + addFee;
			System.out.println("Price : RM" +totprice + "\nTax: RM" + df.format(tax_payment) +"\nDelivery Fee: RM "+ addFee + "\nTotal Payment: RM"+df.format(payment));
			pw.println("Price : RM" +totprice);
			pw.println("Tax: RM" + df.format(tax_payment));
			pw.println("Delivery Fee: RM "+ addFee);
			pw.println("Total Payment: RM"+df.format(payment));
			double cash = Double.parseDouble(JOptionPane.showInputDialog("Enter cash: RM"));
			System.out.println("Cash: RM"+cash+"\nBalance: RM"+df.format((cash-payment)));
			pw.println("Cash: RM"+cash);
			pw.println("Balance: RM"+df.format((cash-payment)));
		}
		else {
			double interest = 1; 
			tax_payment = tax * totprice;
			payment = totprice + tax_payment + interest +addFee;
			System.out.println("Price : RM" +totprice + "\nTax: RM" + df.format(tax_payment) + "\nDelivery Fee: RM "+ addFee +"\nPayment Method : Card \nInterest: RM "+ interest + "\nTotal Payment: RM"+df.format(payment));
			pw.println("Price : RM" +totprice );
			pw.println("Tax: RM" + df.format(tax_payment));
			pw.println("Delivery Fee: RM "+ addFee);
			pw.println("Payment Method : Card");
			pw.println("Interest: RM "+ interest);
			pw.println("\nTotal Payment: RM"+df.format(payment));
		}
	}
	
	public String toString(){return ("Delivery No: " +deliveryNo);}
}