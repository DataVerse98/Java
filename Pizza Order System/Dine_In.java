//Pizza class Dine_In
import javax.swing.*;
import java.text.*;
import java.io.*;

public class Dine_In extends Order{
	private int tableNo;
	public Cashier cashier;
	
	public Dine_In(){
		super();
		tableNo = 0;
		cashier = null;
	}
	
	public Dine_In(int i, /*String t,*/ String d, String p, int q, Pizza pz, int tableNo, Cashier cashier){//int id, String nm){
		super(i,d,p,q,pz);
		this.tableNo = tableNo;
		this.cashier = cashier;//new Cashier(id,nm);
	}
	
	public void setTable(int t){tableNo = t;}
	
	public int getTable(){return tableNo;}
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void calcTotalPayment(double totprice, PrintWriter pw){   //String pymt
		String pymt = getPaymentType();
		double tax = 0.06;
		double payment,tax_payment;
		if(pymt.equalsIgnoreCase("Cash")){
			tax_payment = tax * totprice;
			payment = totprice + tax_payment;
			System.out.println("Price : RM" +totprice + "\nTax: RM" +df.format(tax_payment) + "\nTotal Payment: RM"+df.format(payment));
			pw.println("Price : RM" +totprice);
			pw.println("Tax: RM" +df.format(tax_payment));
			pw.println("Total Payment: RM"+df.format(payment));
			double cash = Double.parseDouble(JOptionPane.showInputDialog("Enter cash: RM"));
			double balance = cash - payment;
			System.out.println("Cash: RM"+cash+"\nBalance: RM"+df.format(balance));
			pw.println("Cash: RM"+cash);
			pw.println("Balance: RM"+df.format(balance));
		}
		else {
			double interest = 1; 
			tax_payment = tax * totprice;
			payment = totprice + tax_payment + interest;
			System.out.println("Price : RM" +totprice + "\nTax: RM" +df.format(tax_payment) +"\nPayment Method :Card \nInterest: RM "+ interest + "\nTotal Payment: RM"+ df.format(payment));
			pw.println("Price : RM" +totprice);
			pw.println("Tax: RM"+df.format(tax_payment));
			pw.println("Payment Method :Card");
			pw.println("Interest: RM "+ interest);
			pw.println("Total Payment: RM"+ df.format(payment));
		}
	}
	
	
	
	
	public String toString(){
		return ("Table No: " +tableNo);
	}
}