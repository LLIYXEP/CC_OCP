package exam.aufgaben;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ListResourceBundle;

public class AufgabeLocaleSimple_de extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		
		String pattern = "d, MMMM YYY";
		LocalDate date = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
		String date2 = date.format(fmt);
		
		return new Object[][] {
			{"date", "Heute ist " + date2},
			{"tag", "Es ist Dienstag."}
		};
	}

}
