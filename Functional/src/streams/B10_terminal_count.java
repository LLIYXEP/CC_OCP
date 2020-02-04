package streams;

import java.util.stream.Stream;

public class B10_terminal_count {

	public static void main(String[] args) {
		
		long result = Stream.of(1,2,3,4,5,6)
			.filter(x -> x%2 == 0)
			.count();
		
		System.out.println("result :" + result); // 3
		
	}
	
}
