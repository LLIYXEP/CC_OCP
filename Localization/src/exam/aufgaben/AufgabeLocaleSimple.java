package exam.aufgaben;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ListResourceBundle;

public class AufgabeLocaleSimple extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		
		String pattern = "MMMM d, YYY";
		LocalDate date = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
		String date2 = date.format(fmt);
		
		return new Object[][] {
			{"date", "Today is " + date2},
			{"tag", "It's Tuesday."}
		};
	}

}
