
//application class

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class TestPizza{
	public static void main(String args []) throws IOException{
		Pizza [] pizza = new Pizza [9];
		
		File out = new File("menu.txt");
		FileReader fr = new FileReader(out);
		BufferedReader br = new BufferedReader(fr);
		
		int index = 0;
		String str = br.readLine();
		while(str != null){
			StringTokenizer st = new StringTokenizer(str,";");
			String menu = st.nextToken();
			String size = st.nextToken();
			double price = Double.parseDouble(st.nextToken());
			
			Pizza pz = new Pizza(menu,size,price);
			pizza[index] = pz;
			
			index++;
			str = br.readLine();
		}
		
		//Order order = new Order();
		//user input 1. Dine-in, 2. Delivery
		Order [] ord = new Order [100];
		int option = Integer.parseInt(JOptionPane.showInputDialog("1. Dine-in || 2. Delivery: "));
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Calendar mus = Calendar.getInstance(TimeZone.getTimeZone("GMT"),Locale.US);
		Calendar clinton = Calendar.getInstance();
		
		mus.set(Calendar.HOUR_OF_DAY,16);
		mus.set(Calendar.MINUTE,0);
		mus.set(Calendar.SECOND,0);
		clinton.set(Calendar.HOUR_OF_DAY,22);
		clinton.set(Calendar.MINUTE,0);
		clinton.set(Calendar.SECOND,0);
		
		GregorianCalendar currentTime = new GregorianCalendar();
		currentTime.get(Calendar.HOUR_OF_DAY);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		
		System.out.println("\tNo.\tMenu\t\t\t\tSize\tPrice");
		for(int a = 0;a<pizza.length;a++){
			System.out.println("\n\t"+(a+1)+"\t"+pizza[a].getPizzaName()+"\t"+pizza[a].getPizzaSize()+"\t"+pizza[a].getPizzaPrice());
		}
		
		Cashier [] cshr =  new Cashier[2];
		cshr[0] = new Cashier(111,"Mustamin");
		cshr[1] = new Cashier(222,"Clinton");
		
		double stop =0;
		int counter = 0;
		
		
		
		double stop2 =0;
		
		int orderNo = 1;
		int b = 0;
		double deliveryNo = 1;
		int cusID = 1;
		
		File in = new File("receipt.txt");
		FileWriter fw = new FileWriter(in);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		while(option!=0){
			
			Pizza [] pzz = new Pizza [50];
			Pizza [] pzz2 = new Pizza [50];
			
			int countPzz = 0;
			int countPzz2 = 0;
		
			if(option ==1){
				
				int tableNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Table No: "));
				Dine_In [] dIn;
				//Number type of pizza that customer want
				int numPiz = Integer.parseInt(JOptionPane.showInputDialog("Enter Number Type of pizza: "));
				dIn = new Dine_In [numPiz];
				do{ 
					
					int menu = Integer.parseInt(JOptionPane.showInputDialog("Enter menu no: "));
					int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity: "));
					pzz[countPzz] = pizza[(menu-1)];
					dIn[countPzz] = new Dine_In(orderNo,sdf.format(currentTime.getTime()),"unknown",quantity,pzz[countPzz],tableNo,null);
					countPzz++;
					
				}while(countPzz<numPiz);	
				
					double sumPrice =0;
					for(int a = 0; a<countPzz;a++){
						sumPrice = sumPrice + dIn[a].calcPrice();
					}
					
					String paymentMethod = JOptionPane.showInputDialog("cash || card :");
					
					if(currentTime.compareTo(mus) <0){
						
						ord[b] = new Dine_In(orderNo,sdf.format(currentTime.getTime()),paymentMethod,0,null,tableNo,cshr[0]);
						Dine_In dn = (Dine_In)ord[b];
						displayReceipt(dn,dIn,sumPrice,pw);
						//System.out.println("Mus is taking your order");
				
					}
					else if(currentTime.compareTo(clinton) <0){
						ord[b] = new Dine_In(orderNo,sdf.format(currentTime.getTime()),paymentMethod,0,null,tableNo,cshr[1]);
						Dine_In dn = (Dine_In)ord[b];
						displayReceipt(dn,dIn,sumPrice,pw);
						//System.out.println("Clinton is taking your order");
					}
					
			}
			else{
				Delivery [] dlvry;
				
				int numPiz = Integer.parseInt(JOptionPane.showInputDialog("Enter Number Type of pizza: "));
				dlvry = new Delivery[numPiz];
				
				do{
					int menu = Integer.parseInt(JOptionPane.showInputDialog("Enter menu no: "));
					int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity: "));
					pzz2[countPzz2] = pizza[(menu-1)];
					dlvry[countPzz2] = new Delivery(orderNo,sdf.format(currentTime.getTime()),"unknown",quantity,pzz2[countPzz2],deliveryNo,null,null);
					countPzz2++;
				}while(countPzz2<numPiz);

				double sumPrice =0;
				for(int a = 0; a<countPzz2;a++){
					sumPrice = sumPrice + dlvry[a].calcPrice();
				}
				
				String paymentMethod = JOptionPane.showInputDialog("cash || card :");
				
				Customer customer;
				Address address;
				
				String name = JOptionPane.showInputDialog("Enter Name: ");
				String hp = JOptionPane.showInputDialog("Enter hp: ");
				
				customer = new Customer(name,hp,cusID);
				
				String street = JOptionPane.showInputDialog("Street: ");
				String city = JOptionPane.showInputDialog("City: ");
				String state = JOptionPane.showInputDialog("State: ");
				String postcode = JOptionPane.showInputDialog("Postcode: ");
				
				address = new Address(street,city,state,postcode);
				
				ord[b] = new Delivery(orderNo,sdf.format(currentTime.getTime()),paymentMethod,0,null,deliveryNo,customer,address);
				Delivery dlry = (Delivery)ord[b];
				displayReceipt(dlry,dlvry,sumPrice,pw);
				
				//System.out.println("Your order is a delivery");
			}
			orderNo++;
			deliveryNo++;
			cusID++;
			b++;
			counter++;
			option = Integer.parseInt(JOptionPane.showInputDialog("1. Dine-in || 2. Delivery || 0. To Stop: "));
			
			
		}
		pw.close();
		
	}
	
public static void displayReceipt(Dine_In ord,Dine_In dIn[],double sumPrice, PrintWriter pw){
		System.out.println();
		pw.println();
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		System.out.println("\t\t\tHello World Pizza");
		pw.println("\t\t\tHello World Pizza");
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		//Cashier 
		System.out.println("Cashier: "+ ord.cashier.getCashierName());
		pw.println("Cashier: "+ ord.cashier.getCashierName());
		System.out.println("Order No. : "+ ord.getOrderID());
		pw.println("Order No. : "+ ord.getOrderID());
		System.out.println("Order Type: Dine-in");
		pw.println("rder Type: Dine-in");
		System.out.println("\t\t\t"+ord.getOrderDate());
		pw.println("\t\t\t"+ord.getOrderDate());
		//display menu that has been order
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		System.out.println("\tQty\tDescription\t\t\tsize\tprice\ttot price");
		pw.println("\tQty\tDescription\t\t\tsize\tprice\ttot price");
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		for(int aa = 0;aa<dIn.length;aa++){
			dIn[aa].displayOrder(pw);
		}
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		//Display total price
		System.out.println("Total Price : RM"+sumPrice);
		pw.println("Total Price : RM"+sumPrice);
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		ord.calcTotalPayment(sumPrice,pw);
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		
	}
	
public static void displayReceipt(Delivery ord,Delivery dlvry[],double sumPrice, PrintWriter pw){
		System.out.println();
		pw.println();
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		System.out.println("\t\t\tHello World Pizza");
		pw.println("\t\t\tHello World Pizza");
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		//Delivary No
		System.out.println(ord.toString());
		pw.println(ord.toString());
		//System.out.println("Cashier: "+ ord.cashier.getCashierName());
		System.out.println("Order No. : "+ ord.getOrderID());
		pw.println("Order No. : "+ ord.getOrderID());
		System.out.println("Order Type: Delivery");
		pw.println("Order Type: Delivery");
		//customer
		System.out.println(ord.deliveryCus.toString());
		pw.println(ord.deliveryCus.toString());
		//address
		System.out.println(ord.getDeliveryAddress());
		pw.println(ord.getDeliveryAddress());
		//date
		System.out.println("\t\t\t"+ord.getOrderDate());
		pw.println("\t\t\t"+ord.getOrderDate());
		//display menu that has been order
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		System.out.println("\tQty\tDescription\t\t\tsize\tprice\ttot price");
		pw.println("\tQty\tDescription\t\t\tsize\tprice\ttot price");
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		for(int aa = 0;aa<dlvry.length;aa++){
			dlvry[aa].displayOrder(pw);
		}
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		//Display total price
		System.out.println("Total Price : RM"+sumPrice);
		pw.println("Total Price : RM"+sumPrice);
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		ord.calcTotalPayment(sumPrice,pw);
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
	}
}