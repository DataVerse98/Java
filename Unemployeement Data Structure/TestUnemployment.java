//application for Unemployment.java

import java.util.*;
import java.io.*;
import javax.swing.*;

public class TestUnemployment{
	public static void main(String [] args){
	try{
		/*ArrayList*/
		ArrayList <Unemployment> AList = new ArrayList();
		
		File myFile = new File("unemployment.txt");
		FileReader fr = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine(); //skip first line
		String str2 = br.readLine();
		
		while(str2!=null){
			StringTokenizer st = new StringTokenizer(str2,",");
			String s = st.nextToken();
			int y = Integer.parseInt(st.nextToken());
			double r = Double.parseDouble(st.nextToken());
			
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
		for(int i=0;i<AList2.size();i++){
			System.out.println((AList2.get(i)).toString());	
		}//end for
	} //end try
	
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	}
}

