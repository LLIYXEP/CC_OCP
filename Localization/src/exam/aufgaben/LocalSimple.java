package exam.aufgaben;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalSimple {

	public static void main(String[] args) {
		
		
		String baseName = "exam.aufgaben.AufgabeLocaleSimple";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String date = bundle.getString("date");
		System.out.println(date);
		String tag = bundle.getString("tag");
		System.out.println(tag);
		
		Locale.setDefault(Locale.UK);
		ResourceBundle bundle2 = ResourceBundle.getBundle(baseName);
		
		String date2 = bundle2.getString("date");
		System.out.println(date2);
		String tag2 = bundle2.getString("tag");
		System.out.println(tag2);
		
		
	}
	
}
