package functional;

public class B02_Lambdas {

	public static void main(String[] args) {
		
		//anonyme Klasse
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("r1");
			}
		};
		
		// Lambda
		Runnable r2 = () -> {
			System.out.println("r2");
		};
		
		activate(r1);
		activate(r2);
		
		//anonyme Klasse
		activate(new Runnable() {
			public void run() {
				System.out.println("r3");
			}
		});
		
		// Lambda
		activate( () -> {
			System.out.println("r4");
		});
		
		
	} // end of main
	
	static void activate ( Runnable r) {
		r.run();
	}
	
}
