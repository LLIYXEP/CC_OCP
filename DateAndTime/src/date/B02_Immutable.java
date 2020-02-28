package date;

import java.time.LocalTime;

public class B02_Immutable {

	public static void main(String[] args) {
		
		int hour = 2;
		int minute = 7;
		
		LocalTime var = LocalTime.of(hour, minute);
		
		var.minusHours(1); // Immutable!
		
		System.out.println(var.getHour()); // 2
		
		
		
	}
	
}
