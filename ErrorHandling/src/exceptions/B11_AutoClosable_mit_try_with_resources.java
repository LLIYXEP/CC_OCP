package exceptions;

class Res01 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close 1");
	}
	
}

class Res03 implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("close 3");
	}
	
}

public class B11_AutoClosable_mit_try_with_resources {

	public static void main(String[] args) {
		
//		try (String res = new String()) {	// CF : AutoClosable benotigt
//			
//		} 
		
		
//		try (Res01 res = new Res01()) {	// CF : checked Exception beim close-Aufruf moglich (s. Klasse Res01)
//			
//		} 
		
		System.out.println("*************");
		
		try (Res01 res = new Res01()) {	
			System.out.println("try 1");
		} catch (Exception e) {				// close - aufruf gibt es auch!
			System.out.println("catch 1");
		}
		
		System.out.println("*************");
		
		try (Res01 res = new Res01()) {	
			System.out.println(5/0);
		} catch (Exception e) {				// close - aufruf gibt es auch!
			System.out.println("catch 2");
		} 
		
		System.out.println("*************");
		
		try (Res03 res = new Res03()) {	
			
		} finally {
			System.out.println("finally 3");
		}
		
		System.out.println("*************");
		
		try (Res03 res = new Res03()) {	
			System.out.println("try 4");
		} 
		
		System.out.println("*************");
		
		try (Res03 res = new Res03()) {	
//			res = new Res03();	// CF : ress muss 'effelcively final' bleiben
		}
		
//		Res03 resMain;
//		try (resMain = new Res03()) {	// CF : resMain muss Blockvariable sein
//			
//		}
		
		
		
	}
	
}
