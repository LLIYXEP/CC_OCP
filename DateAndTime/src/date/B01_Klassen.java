package date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class B01_Klassen {

	public static void main(String[] args) {
		
		Date d; // Millis seit dem 1.1.1970 (seit Java 1)
		
		Instant x0; // Millis seit dem 1.1.1970 (seit Java 8)

		LocalTime x1;
		LocalDate x2;
		LocalDateTime x3;
		
		ZoneId zone; // A time-zone ID, such as Europe/Paris. 
		ZonedDateTime x4; // Time + Date + ZoneId
		
		Period x5; // A date-based amount of time in the ISO-8601 calendar system,such as '2 years, 3 months and 4 days'. 
		Duration x6; // A time-zone ID, such as Europe/Paris. 
		
		DateTimeFormatter fmt;
		
		
	}

}
