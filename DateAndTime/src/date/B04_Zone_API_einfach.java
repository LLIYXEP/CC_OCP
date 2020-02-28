package date;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class B04_Zone_API_einfach {

	public static void main(String[] args) {
		
		Set<String> allZoneIDs = ZoneId.getAvailableZoneIds();
		
//		allZoneIDs.stream()
//			.filter(name -> name.contains("Berlin"))
//			.forEach(System.out::println);
		
		ZoneId zid1 = ZoneId.of("Europe/Berlin");
		System.out.println(zid1);
		
		ZoneId zid2 = ZoneId.of("US/Central");
		System.out.println(zid2);
		
		
		ZonedDateTime date1 = ZonedDateTime.now();
		System.out.println("date1: " + date1); // date1: 2020-02-28T09:25:37.387598300+01:00[Europe/Berlin]
		
		ZonedDateTime date2 = ZonedDateTime.now(zid2);
		System.out.println("date2: " + date2); // date2: 2020-02-28T02:27:42.230968200-06:00[US/Central]
		
		
		ZoneId berlinID = ZoneId.of("UTC+1");
		ZonedDateTime dateA = ZonedDateTime.now(berlinID);
		System.out.println("dateA: " + dateA); // 2020-02-28T09:52:51.972628100+01:00[UTC+01:00]
		
		ZonedDateTime dateB = dateA.plusMonths(8);
		System.out.println("dateB: " + dateB); // 2020-10-28T09:54:10.807365900+01:00[UTC+01:00]
	}
	
}
