package functional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class B12_Optional_API {

	public static void main(String[] args) {
		
		/*
		 * Optional bilden: empty, of , ofNullable
		 */
		Optional<Integer> op1 = Optional.empty();
		Optional<Integer> op2 = Optional.of(12);
		
		try {
			Optional.of(null);      //   NullPointerException
		} catch (NullPointerException e) {
			System.out.println("Fehler! Keine null fur die of - Methode moglich");
		}
		
		Optional<Integer> op3 = Optional.ofNullable(12);
		Optional<Integer> op4 = Optional.ofNullable(null);
		
		/*
		 * boolean isPresent()
		 */
		System.out.println("op1.isEmpty() " + op1.isEmpty()); // true (ab Java 11)
		System.out.println("op1.isPresent() " + op1.isPresent()); // false
		
		/*
		 * T get()
		 */
		try {
			op1.get(); // java.util.NoSuchElementException
		} catch (Exception e) {
			System.out.println("Fehler! op1 is leer - No value present");
		}
		Integer value = op2.get();
		System.out.println(value);
		
		System.out.println(" ----------------- ifPresent-------------------- ");
		
		/*
		 * Optional verwenden. Variante 1:
		 */
		
		if (op2.isPresent()) {
			System.out.println(op2.get());
		}
		
		/*
		 * Optional verwenden. Variante 2 (functionale):
		 * 
		 * ifPresent(Consumer<? super T> action)
		 */
		Consumer<Integer> consumer = x -> System.out.println(x);
		op2.ifPresent(consumer);
		
		op2.ifPresent(x -> System.out.println(x));
		
		System.out.println(" ------------------ orElse------------------- ");
		
		/*
		 * T orElse(T)
		 */
		
		Integer var = null;
		Optional<Integer> op5 = Optional.ofNullable(var); 
		
//		System.out.println(op5.get()); // NoSuchElementException
		
		Integer orElse = op5.orElse(-1);
		System.out.println(orElse);     // -1
		
		System.out.println(" ---------------- orElseGet--------------------- ");
		
		/*
		 * orElseGet(Supplier<? extends T> supplier)
		 */
		
		Optional<Integer> op6 = Optional.empty(); 
		
		Supplier<Integer> supplier = () -> 5;
		Integer result6 = op6.orElseGet(supplier);
		System.out.println(result6);
		
		System.out.println(" ---------------- orElseGet--------------------- ");
		
		/*
		 * orElseGet(Supplier<? extends T> supplier)
		 */
		Optional<Integer> op7 = Optional.empty(); 
		
		Supplier<IllegalArgumentException> excSupplier = () -> new IllegalArgumentException("op7 war leer");
		
		try {
			Integer result7 = op7.orElseThrow(excSupplier);
			System.out.println(result7);
		} catch (IllegalArgumentException e) {
			System.out.println("Fehler: " + e);
		}
		
//		op7.orElseThrow(() -> new Exception()); // CF - checked Exception
	}
	
}
