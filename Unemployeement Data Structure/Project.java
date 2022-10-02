import java.io.*;
import java.util.*;
import javax.swing.*;

public class Project {
	public static void main(String [] args) throws IOException{
		
		/*ArrayList*/
		ArrayList <Unemployment> AList = new ArrayList();
		//read file from unemployment.txt
		File myFile = new File("unemployment.txt");
		FileReader fr = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine(); //skip first line
		String str2 = br.readLine();
		
		while(str2!=null){
			StringTokenizer st = new StringTokenizer(str2,",");		//use string tokenize to seperate line
			String s = st.nextToken();
			int y = Integer.parseInt(st.nextToken());
			double r = Double.parseDouble(st.nextToken());
			
			//add unemployement obj into the ArrayList
			Unemployment u = new Unemployment(s,y,r);
			AList.add(u);
			
			str2 = br.readLine();
		}//end while
		br.close();		//close br
		
		/*for(int i=0;i<AList.size();i++){
			System.out.println((AList.get(i)).toString());	
		}*/
		
		ArrayList<Unemployment> AList2 = new ArrayList();	//new ArrayList
		for(int a=0;a<AList.size();a++){
			Unemployment u1 = AList.get(a);
			if(u1.getState().equalsIgnoreCase("W.P.Putrajaya")){
				if(u1.getYear()<1992){
					AList.remove(a);	//remove list from W.P.Putrajaya before 1992
					AList2.add(u1);		//add removed list in to the new ArrayList
					a--;
				}//end if
			}//end if
			
		}//end for
		
		
		//display data in the new ArrayList
		System.out.println("Removed data from W.P. Putrajaya before 1992:");
		for(int i=0;i<AList2.size();i++){
			System.out.println((AList2.get(i)).toString());	
		}//end for
		
		
		/*LinkedList*/
		
		//retrieve data from AList and insert to LList 
		LinkedList<Unemployment>LList = new LinkedList();
		
		for(int b=0;b<AList.size();b++){
			Unemployment u2 = AList.get(b);
			LList.add(u2);
		}
		/*for(int i=0;i<LList.size();i++){
			System.out.println((LList.get(i)).toString());	
		}*/
		//user input for state
		int option = Integer.parseInt(JOptionPane.showInputDialog("1. Johor\n2.Kedah\n3.Kelantan\n4.Malaysia\n5.Melaka\n6.Negeri Sembilan\n7.Pahang\n8.Perak\n9.Perlis\n10.Pulau Pinang\n11.Sabah\n12.Sarawak\n13.Selangor\n14.Terengganu\n15.W.P Labuan\n16.W.P. Kuala Lumpur\n17.W.P.Putrajaya"));
		
		
		Unemployment u3 = LList.get(0);
		double n = u3.getRate();
		Unemployment highest = new Unemployment("unknown",0,n);		// create new Unemployment obj. to store the highest value
		System.out.println();
		//search for the state from user input and get the highest unemployment rate from that state
		for(int c=0;c<LList.size();c++){
			Unemployment u4 = LList.get(c);
			double value = u4.getRate();
			if((option==1)&&(u4.getState().equals("Johor"))){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==2 && u4.getState().equals("Kedah")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==3 && u4.getState().equals("Kelantan")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==4 && u4.getState().equals("Malaysia")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==5 && u4.getState().equals("Melaka")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==6 && u4.getState().equals("Negeri Sembilan")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}else
			if(option==7 && u4.getState().equals("Pahang")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==8 && u4.getState().equals("Perak")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==9 && u4.getState().equals("Perlis")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==10 && u4.getState().equals("Pulau Pinang")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==11 && u4.getState().equals("Sabah")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==12 && u4.getState().equals("Sarawak")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==13 && u4.getState().equals("Selangor")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==14 && u4.getState().equals("Terengganu")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==15 && u4.getState().equals("W.P Labuan")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==16 && u4.getState().equals("W.P. Kuala Lumpur")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option==17 && u4.getState().equals("W.P.Putrajaya")){
				if(value>highest.getRate()){
					highest = u4;
				}
			}
			if(option>17||option<0){
				System.out.println("Sorry, the input is not available!!!");
				break;
			}
		}
		System.out.println();
		System.out.println("Highest rate for that state is: ");		//display the details of the highest rate from the user input state 
		System.out.println(highest.toString());
		System.out.println();
		
		//create new LinkedList n and store a removed obj from the the first linkedlist
		LinkedList LList2 = new LinkedList();
		for(int x=0;x<LList.size();x++){
			Unemployment u5 = LList.get(x);
			String s1 = u5.getState();
			if(s1.equals("W.P.Putrajaya")){
				if(u5.getYear()<2011){
					Unemployment u6 = LList.remove(x);		//remove obj from LList
					LList2.add(u6);							//store removed obj to new linkedlist
				}
			}
		}
		//display the second LinkedList
		System.out.println("Removed data from W.P. Putrajaya before 2011:");
		for(int i=0;i<LList2.size();i++){
			System.out.println((LList2.get(i)).toString());	
		}
		
		/*Stack*/
		//create a stack obj.
		Stack<Unemployment>ListS = new Stack();
		System.out.println();
		//ask user input the year from 1982-2016
		//insert the inputed year to the stack obj.
		int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year from (1982-2016): "));
		for(int y=0;y<LList.size();y++){
			Unemployment u7 = LList.get(y);
			if(year==u7.getYear()){
				ListS.push(u7);
			}else if(year>=1982&&year<=2016){
				continue;
				//break;
			}else{
				System.out.println("Sorry, the input is not available!!!");
				break;
			}
		}
		
		//ask user input to change the rate from Sarawak based on the year being asked
		Stack<Unemployment>ListS2 = new Stack();
		while(!ListS.isEmpty()){
			Unemployment u8 = ListS.pop();
			if(u8.getState().equals("Sarawak")){
				double change =  Double.parseDouble(JOptionPane.showInputDialog("Enter new rate for Sarawak on :"));
				u8.setRate(change);
			}
			//System.out.println(u8.toString());
			ListS2.push(u8);
		}
		System.out.println();
		System.out.println();
		//x perlu
		
		Stack<Unemployment>tempS = new Stack();
		while(!ListS2.isEmpty()){
			Unemployment ug = ListS2.pop();
			System.out.println(ug.toString());
			tempS.push(ug);
		}
		while(!tempS.isEmpty()){
			Unemployment uu = tempS.pop();
			ListS2.push(uu);
		}
		
		//Stack temp = new Stack();
		/*while(!ListS2.isEmpty()){
			Unemployment u9 = ListS2.pop()
			System
		}*/
		
		/*Queue*/
		//create a queue obj and get the unemployement object from the LList
		Queue Q1 = new Queue();
		for(int i=0;i<LList.size();i++){
			Unemployment u9 = LList.get(i);
			Q1.enqueue(u9);
		}
		
		//create 3 new obj for update, remove, and as a temporary stack
		Queue updQ = new Queue();
		Queue rmvQ = new Queue();
		Queue temp = new Queue();
		while(!Q1.isEmpty()){
			Unemployment u10 = (Unemployment)Q1.dequeue();
			if(u10.getState().equals("W.P Labuan")){		//remove data from W.P. Labuan before the year 1984
				if(u10.getYear()<1984){
					rmvQ.enqueue(u10);						//store it to the remove queue
				}else{
					temp.enqueue(u10);						//else store to the temporary queue
				}
			}else{
				temp.enqueue(u10);
			}
		}
		while(!temp.isEmpty()){
			updQ.enqueue(temp.dequeue());					//retrieve the data from temp queue to the update queue
		}
		
		
		//testing
		/*
		while(!updQ.isEmpty()){
			Unemployment u11 = (Unemployment)updQ.dequeue();
			System.out.println(u11.toString());
			temp.enqueue(u11);
		}
		while(!temp.isEmpty()){
			updQ.enqueue(temp.dequeue());
		}
		*/
		//Binary Search Tree
		
		System.out.println();
		System.out.println();
		//Display the states that have unemployment rate below 3.0.
		
		BSTUnemployment bst2016 = new BSTUnemployment();
		
		while(!updQ.isEmpty()){
			Unemployment u12 = (Unemployment)updQ.dequeue();
			if(u12.getYear() == 2016)
				bst2016.insertNode(u12);
			else
				temp.enqueue(u12);
		}//retrieve data from updQ and store data from year 2016 into bst2016
		
		while(!temp.isEmpty()){
			updQ.enqueue(temp.dequeue());
		}
		
		System.out.println("State unemployment rate below 3.0:");
		bst2016.displayState(3.0);
		
		System.out.println();
		bst2016.aveRate();
		
	}//end main
}//end class


























