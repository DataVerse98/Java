public class Unemployment{
	//attributes
	private String state;
	private int year;
	private double rate;
	
	//default constructor
	public Unemployment(){
		state="unknown";
		year = 0;
		rate = 0;
	}
	
	//public constructor
	public Unemployment(String s, int y, double r){
		state = s;
		year = y;
		rate = r;
	}
	
	//getter
	public String getState(){return state;}
	public int getYear(){return year;}
	public double getRate(){return rate;}
	
	//setter
	public void setState(String s){state = s;}
	public void setYear(int y){year = y;}
	public void setRate(double r){rate = r;}
	
	//toString
	public String toString(){
		return (state+"\t"+year+"\t"+rate);
	}
}















