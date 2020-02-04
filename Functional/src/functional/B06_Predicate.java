package functional;

import java.util.function.Predicate;

public class B06_Predicate {

	public static void main(String[] args) {
		
		Predicate<Integer> p1 = new Predicate<Integer>() {
			public boolean test(Integer param) {
				return param > 0;
			}
		};
		
		Predicate<Integer> p2 = param -> param > 0;
		
		witereMethoden();
		
	}
	
	static void witereMethoden() {
		
		System.out.println("****** Default Predicate and( Predicate ) *********");
		
		Predicate<String> predicateNotNull = s -> s != null;
		
		Predicate<String> predicateGreater3 = s -> s.length() > 3;
		
		Predicate<String> p1 = predicateNotNull.and(predicateGreater3);
		
		System.out.println(p1.test(null)); // false
		System.out.println(p1.test("Do")); // false
		System.out.println(p1.test("Dienstag")); // true
		
		System.out.println("****** Default Predicate negate() *********");
		
		Predicate<String> p2 = p1.negate();
		
		System.out.println(p2.test("Do")); // true
		System.out.println(p2.test("Do000")); // false
		
		System.out.println("****** Default Predicate or() *********");
		
		Predicate<Integer> predicateGreater2 = x -> x < 2;
		
		Predicate<Integer> p3 = predicateGreater2.or(y -> y > 7);
		
		System.out.println(p3.test(12)); // true
		System.out.println(p3.test(5)); // false
		
		
		
		
//		BiConsumer<Integer, String> b1 = new BiConsumer<Integer, String>() {
//			
//			@Override
//			public void accept(Integer t, String u) {
//				System.out.println(u + t);
//			}
//		};
//		
//		b1.accept(22, "Hahaha ");
//		
//		UnaryOperator<Integer> u1 = new UnaryOperator<Integer>() {
//			
//			@Override
//			public Integer apply(Integer t) {
//				return 22;
//			}
//		};
//		
//		u1.apply(12);
	}
	
}
