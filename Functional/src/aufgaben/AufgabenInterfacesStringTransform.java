package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

//interface StringTransform {
//	String execute(String s);
//}

public class AufgabenInterfacesStringTransform {

	public static void main(String[] args) {
		
		String[] arr = {"mo", "di", "mi"};
		
		List<String> list = transform(arr, (s) -> s.toUpperCase());
		
		System.out.println(list); // [MO, DI, MI]
		
		list = transform(arr, (s) -> s + ".");
		System.out.println(list);
		
		list = transform(arr, (s) -> "(" + s + ")");
		System.out.println(list);
		
	}
	
	static List<String> transform(String[] values, UnaryOperator<String> logic){
		
		List<String> list = new ArrayList<String>();
		
		for (String s : values) {
			s = logic.apply(s);
			list.add(s);
		}
		
		return list;
	}
	
}
