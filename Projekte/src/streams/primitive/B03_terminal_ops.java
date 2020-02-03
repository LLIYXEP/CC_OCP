package streams.primitive;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class B03_terminal_ops {

	public static void main(String[] args) {
		
		OptionalDouble maybeAverage = IntStream.of(1, 2, 3)
										.average();
		
		System.out.println("average: " + maybeAverage.getAsDouble());
		
		
		
		int sum = IntStream.of(1, 2, 3)
						.sum();
		System.out.println(sum); // 6
		
		
		
		IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 3, 4, 5)
					.summaryStatistics();
		System.out.println(summaryStatistics); // IntSummaryStatistics{count=5, sum=15, min=1, average=3,000000, max=5}
	}
	
}
