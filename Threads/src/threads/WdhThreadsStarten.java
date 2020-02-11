package threads;

public class WdhThreadsStarten {
	
	public static void main(String[] args) {
		
//		frage02();
//		frage01();
		frage03();
		
	}
	
	public static void frage03() {
		Runnable target = new Runnable() {		
			@Override
			public void run() {
				System.out.println("Maus");
			}
		};
		
		new Thread(target) {
			@Override
			public void run() {
//				super.run(); // Maus
				System.out.println("Katze");
			}
		}.start(); // Katze
		
		
		
	}
	
	public static void frage02() {
		new Thread() {
			@Override
			public void run() {
				System.out.println("run"); // 1
			}
		}.run();
		
		
		System.out.println("main"); // 2
	}

	public static void frage01() {
		
		new Thread() {
			@Override
			public void run() {
				System.out.println("run");
			}
		}.run();
		
		
		System.out.println("main"); // 1 und einzige Ausgabe
	}
	
}
