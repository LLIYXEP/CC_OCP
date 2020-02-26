package exam;

import java.util.Properties;
import java.util.Set;

public class B02_SystemProperties {

	public static void main(String[] args) {
		
		/*
		 * Properties getProperties()
		 */
		Properties props = System.getProperties();
		
		Set<Object> keySet = props.keySet();
		
		for (Object key : keySet) {
			Object value = props.get(key);
			System.out.printf("%30s = %s %n", key, value);
		}
		
		System.out.println("***********");
		
		/*
		 * String getProperty(String)
		 */
		String property = System.getProperty("user.home");
		System.out.println(property);
		
		System.out.println(props.getProperty("user.home"));
		
		/*
		 * 
		 */
		String valueForBadKey = System.getProperty("badkey", "Kein Wert fur badkey");
		System.out.println(valueForBadKey);
		
		System.out.println(props.getProperty("mykey")); // null
		
		System.setProperty("mykey", "myvalue");
		
		System.out.println(props.getProperty("mykey")); // myvalue
		
		/*
		 * Mit Option fur die VM
		 * 
		 * -Dbenutzer="Max Muller"
		 */
		System.out.println("benutzer: " + System.getProperty("benutzer"));
		
	} // end of main
	
}
