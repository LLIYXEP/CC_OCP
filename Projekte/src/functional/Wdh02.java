package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Wdh02 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3);
		
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println(t);
			}
		});
		
		list.forEach(System.out::println);
		
	}
	
}
