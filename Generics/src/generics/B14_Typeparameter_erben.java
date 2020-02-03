package generics;

interface Randomizer <E>{
	E getRandom(E e1, E e2);
}

// hier wird generischer Typparameter aus dem Basistyp geerbt und die generische Natur im neuen Typ bleibt erhalten
class MyRandomizerImpl <T> implements Randomizer<T>{
	public T getRandom(T e1, T e2) {return e2;}



}

public class B14_Typeparameter_erben {

	public static void main(String[] args) {
		
		MyRandomizerImpl<Integer> r1 = new MyRandomizerImpl<>();
		
		Integer x1 = r1.getRandom(12, 44);
		
		Randomizer<String> r2 = new MyRandomizerImpl<String>();
		String random = r2.getRandom("a", "b");
		System.out.println(random); // b
	}
	
}
