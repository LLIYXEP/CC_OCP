package aufgaben.stream.warenkorb;

import java.util.HashMap;
import java.util.Map;

public class Preise {

	public static Map<String, Integer> STANDART_PRICE = new HashMap<String, Integer>();
	
	static {
		STANDART_PRICE.put("Brot", 129);
		STANDART_PRICE.put("Wurst", 230);
		STANDART_PRICE.put("Milch", 99);
	}
	
}
