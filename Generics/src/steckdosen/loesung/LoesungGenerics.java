package steckdosen.loesung;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface TV {}
class TVDE implements TV{}
class TVUK implements TV{}

class Steckdose<T extends TV> {
	private T tv;
	
	void anschliessen(T tv) {
		this.tv = tv;
	}
	
	public T get() {
		return tv;
	}
}

public class LoesungGenerics {

	public static void main(String[] args) {
		
		TVDE tvDE = new TVDE();
		TVUK tvUK = new TVUK();
		
		Steckdose<TVDE> sdDE = new Steckdose<TVDE>();
		sdDE.anschliessen(tvDE); // muss gehen
//		sdDE.anschliessen(tvUK); // darf nicht kompilieren
		
		Steckdose<TVUK> sdUK = new Steckdose<TVUK>();
//		sdUK.anschliessen(tvDE); // darf nicht kompilieren
		sdUK.anschliessen(tvUK); // muss gehen
		
//		Steckdose<String> sdSinloss = new Steckdose<String>(); // Sinlosse Steckdose sollten nicht moglich sein
//		System.out.println("Ich bin kein Fehrsehen");
		
		Predicate<Integer> pr = (a) -> a > 10;
		pr.test(11);
		Consumer<Integer> cons = (a) -> System.out.println("Result " + a);
		cons.accept(55);
		Supplier<Integer> supp = () -> 5;
		supp.get();
		Function<Integer, String> func = (a) -> "Hahaha " + a;
		func.apply(15);
		
	}
	
}
