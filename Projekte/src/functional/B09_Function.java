package functional;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class B09_Function {

	public static void main(String[] args) {
		
		Function<Integer, String> f1 = new Function<Integer, String>() {
			public String apply(Integer t) {
				return "Value = " + t;
			}
		};
		
		String str = f1.apply(55 + 12);
		System.out.println(str);
		
		Function<Integer, String> f2 = a -> "Value = " + a;
		
		String str2 = f2.apply(22);
		System.out.println(str2);
		
		
		
		witereMethoden();
		
		
		
		
	}
	
	static void witereMethoden() {
		
		Function<Integer, Integer> functionAdd2 = a -> a + 2;
		Function<Integer, Integer> functionMal3 = a -> a * 3;
		
		System.out.println("****** Default Function andThen( Function after) *********");
		
		Function<Integer, Integer> f1 = functionAdd2.andThen(functionMal3);
		
		System.out.println(f1.apply(2)); // 12 ( 2 + 2, dann 4 * 3 )
		
		System.out.println("****** Default Function compose(Function vefore) *********");
		
		Function<Integer, Integer> f2 = functionAdd2.compose(functionMal3);
		System.out.println(f2.apply(2)); // 8	( 2 * 3, dann 6 + 2 )
	}
	
}
