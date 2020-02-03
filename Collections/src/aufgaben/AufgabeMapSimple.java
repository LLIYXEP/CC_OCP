package aufgaben;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AufgabeMapSimple {

	public static void main(String[] args) {
		
		Map<String, LocalDate> map = new HashMap<String, LocalDate>();
		
		LocalDate date1 = LocalDate.of(2020, 01, 14);
		LocalDate date2 = LocalDate.of(2020, 01, 13);
		LocalDate date3 = LocalDate.of(2020, 01, 15);
		
		map.put("heute", date1);
		map.put("gestern", date2);
		map.put("morgen", date3);
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key);
			System.out.println(map.get(key));
		}
		
		System.out.println("***********************************");
		
		Set<Map.Entry<String, LocalDate>> set = map.entrySet();
		for (Map.Entry<String, LocalDate> date : set) {
			System.out.println(date.getKey());
			System.out.println(date.getValue());
		}
		
	}
	
}
