package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Properties;

/*
 * Properties:
 * 
 * 1. abstrakter Begriff: Schlussel-Wert-Paare, die die konfigurierbare Eigenschaften einer Anwendung (Bibliotek) bechsreiben
 * 2. Java-Format zum speichern der SChlussel-Wert-Paare (name-value)
 * 3. Properties ist eine Klasse, die Properties aus 1 und/oder 2 unterstuzt.
 */

public class B01_Properties {

	public static void main(String[] args) {
		
		Properties props = new Properties(); // im Arbeitsspecher
		
		/*
		 * String getProperty(String)
		 */
		String prpertyName = "app.version";
		String propertyValue = props.getProperty(prpertyName);
		
		System.out.println(prpertyName + " = " + propertyValue); // null
		
		
		/*
		 * prpertyName (String key, String defValue)
		 */
		System.out.println(props.getProperty(prpertyName, "1.0.0")); // 1.0.0
		
		
		/*
		 * 
		 */
		String value = Paths.get(".").toAbsolutePath().normalize().toString();
		props.setProperty("app.dir", value);
		
		
		/*
		 * nicht in der Prufung
		 */
		String comments = "my comment";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("myapp.properties"))) {
			props.store(writer, comments);
		} catch (Exception e) {
			
		}
		
		testLoad();
	}
	
	static void testLoad() {
		System.out.println("**** load");
		
		Properties props = new Properties();
		
		try (Reader reader = new BufferedReader(new FileReader("myapp.properties"))) {
			props.load(reader);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String appDir = props.getProperty("app.dir");
		
		System.out.println("app.dir " + appDir);
	}
	
}
