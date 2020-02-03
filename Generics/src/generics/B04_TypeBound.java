package generics;

/*
 * R - extends Runnable
 * 
 * extends steht in diesem Kontext fur 'IS-A-Beziehung'
 */

class Launcher <R extends Runnable>{
	void launch(R r) {
		r.run(); // kompiliert nur, wenn der Compiler sicher sein kann, dass es im Typ R die Methode run() gibt
	}
}

public class B04_TypeBound {
	
	static class Rakete implements Runnable{
		@Override
		public void run() {
			System.out.println("Rakete fliegen...");
		}
	}
	
	interface LauffaehigesLebewesen extends Runnable{
		
	}

	public static void main(String[] args) {
		
//		Launcher<String> launcher1 = new Launcher<>(); // CF wegen Type bound
//		launcher1.launch("Hallo");
		
		Launcher<Runnable> launcher2 = new Launcher<>();
		
		Runnable r = () -> System.out.println("Lambda Runnable");
		launcher2.launch(r);
		
		Launcher<Rakete> launcher3 = new Launcher<>();
		launcher3.launch(new Rakete()); // Rakete fliegen...
		
		Launcher<LauffaehigesLebewesen> launcher4 = new Launcher<>();
	}
}
