import java.util.*;
import java.text.*;

public class TestHour{
	public static void main(String [] args){
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
		
		System.out.println(dateFormat.format(mus.getTime()));
		System.out.println(clinton.getTime());
		System.out.println(currentTime.getTime());
		
		if(currentTime.compareTo(clinton) <0 ){
			System.out.println("Your order is taken by clinton");
		}
	}
}
