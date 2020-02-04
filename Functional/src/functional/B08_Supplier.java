package functional;

import java.util.function.Supplier;

public class B08_Supplier {

	public static void main(String[] args) {
		
		Supplier<Integer> s1 = new Supplier<Integer>() {
			public Integer get() {
				return 55;
			}
		};
		
		System.out.println(s1.get());
		
		Supplier<Integer> s2 = () -> 12;
		
		System.out.println(s2.get());
	}
	
}
