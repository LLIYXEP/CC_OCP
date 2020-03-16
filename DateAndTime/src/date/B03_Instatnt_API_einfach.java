package date;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;

public class B03_Instatnt_API_einfach {

	public static void main(String[] args) {
		
		
		Instant i1 = Instant.now();
		
		
		System.out.println("1: " + i1); // 2020-02-28T07:47:27.185530300Z
		
		Instant i2 = Instant.parse("2020-02-28T07:50:27.185530300Z");
		System.out.println("2: " + i2);
		
		System.out.println(i2.truncatedTo(ChronoUnit.SECONDS)); // 2020-02-28T07:50:27Z
		
		// Immutable
		System.out.println(i2); // 2020-02-28T07:50:27.185530300Z
		
		System.out.println(Instant.parse ( "2010-04-05T17:16:00Z" ));
	}
	
}
