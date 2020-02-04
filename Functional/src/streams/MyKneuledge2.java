package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MyKneuledge2 {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(5,10);
		
		Integer reduce = list.stream()
			.reduce(10, (a,b) -> a+b);
		
		System.out.println(reduce);
			
		
	}
	
}
