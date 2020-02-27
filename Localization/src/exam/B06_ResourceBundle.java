package exam;

import java.util.Locale;
import java.util.ResourceBundle;

public class B06_ResourceBundle {

	public static void main(String[] args) {
		
		Locale defaultLocale = Locale.getDefault();
		System.out.println("default Locale: " + defaultLocale); // de_DE
		
		String baseName = "res.Labels";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName); // ressourcen fur default-Locale
		
//		String greeting = "Guten Tag!";
		String greeting = bundle.getString("text.greeting");
		System.out.println(greeting);
		
		/*
		 * ResourceBundle kann auch ein extra-Locale erstellt werden
		 */
		bundle = ResourceBundle.getBundle(baseName, Locale.CHINA);
		greeting = bundle.getString("text.greeting");
		System.out.println(greeting);
		
//		Object result = bundle.getObject("text.greeting"); // exc
		Object result = bundle.getObject("greeting");
		System.out.println(result);
	}
	
}
