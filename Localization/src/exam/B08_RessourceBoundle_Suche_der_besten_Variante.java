package exam;

import java.util.Locale;
import java.util.ResourceBundle;

public class B08_RessourceBoundle_Suche_der_besten_Variante {
	
	/*
	 * baseName = res.Geo
	 * 
	 * locale = 'ru'
	 * 
	 * id = 'top'
	 * 
	 * Suche (hier nur eine unvorstandige List der Suchschritte)
	 * 
	 * 	- in der Resource 'res.Geo_ru.class'
	 * 	- in der Resource 'res.Geo_ru.properties'
	 * 	- in der Resource 'res.Geo.class'
	 * 	- in der Resource 'res.Geo.properties'
	 */

	public static void main(String[] args) {
		
		String baseName = "res.Geo";
		

		testForLocale(Locale.getDefault());

		testForLocale(new Locale("ru"));
		
		
		
	}
	
	static void testForLocale(Locale loc) {
		System.out.println("**** Locale: " + loc);
		
		String baseName = "res.Geo";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, loc);
		
		String labelCenter = bundle.getString("center");
		System.out.println("center: " + labelCenter);
		
		System.out.println("top: " + bundle.getString("top"));
	}
	
}
