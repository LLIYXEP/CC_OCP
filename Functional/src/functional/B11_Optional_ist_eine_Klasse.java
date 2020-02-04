package functional;

import java.util.Optional;

/*
 * Optional hat mit dem Thema 'Functional' nur bedingt etwas zu tun.
 */
public class B11_Optional_ist_eine_Klasse {
	
	static String getDayName(int dayNumber) {
		switch (dayNumber) {
		case 1: return "mo";
		case 2: return "di";
		}
		return null;
	}
	
	static Optional<String> maybeGetDayName(int dayNumber) {
		switch (dayNumber) {
		case 1: return Optional.of("mo");
		case 2: return Optional.of("di");
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		
		int dayNumber = 22;
		/*
		 * Es kann einfach ubersehen werden, dass unter Umstanden die Methode eine null lieferte
		 */
		String day1 = getDayName(dayNumber);
		if (day1 != null) {
			System.out.println(day1.toUpperCase());
		}
		
		/*
		 * Die Methode aufrufen, die das NullPointer-Sicheres Programieren unterschutzt
		 */
		Optional<String> maybeDay2 = maybeGetDayName(dayNumber);
		if (maybeDay2.isPresent()) {
			String day2 = maybeDay2.get();
			System.out.println(day2.toUpperCase());
		}
		
		
	}
	
}
