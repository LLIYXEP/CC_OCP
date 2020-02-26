package exam;

import java.util.Locale;

public class B03_Klasse_Locale {

	public static void main(String[] args) {
		
		Locale loc1 = new Locale("de"); // Sprache (klein)
		printLocale(loc1);
		
		Locale loc2 = new Locale("de", "DE"); // Sprache (klein), Land (gross)
		
		Locale loc3 = new Locale.Builder()
								.setLanguage("de")
								.setRegion("DE")
								.build();
		
		Locale loc4 = Locale.GERMANY;
		printLocale(loc4);
		
		/*
		 * Locale[] getAvailableLocales()
		 */
		System.out.println("**** available locales: " + Locale.getAvailableLocales().length);
		
		/*
		 * Locale getDefault()
		 */
		Locale defaultLocale = Locale.getDefault();
		
		/*
		 * void setDefault(Locale)
		 */
		Locale newLocale = Locale.CHINA;
		Locale.setDefault(newLocale);
	}
	
	static void printLocale(Locale locale) {
		System.out.println("*** Locale: " + locale);
		System.out.println("getLanguage: " + locale.getLanguage());
		System.out.println("getDisplayLanguage: " + locale.getDisplayLanguage());
		System.out.println("getCountry: " + locale.getCountry());
		System.out.println("getDisplayCountry: " + locale.getDisplayCountry());
	}
	
}
