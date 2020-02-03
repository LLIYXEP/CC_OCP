package exceptions;

public class B13_try_with_resources_mit_mehreren_Ressourcen {
	
	static class Res01 implements AutoCloseable{
		
		public Res01() {
			System.out.print("k1 ");
		}
		
		@Override
		public void close() {
			System.out.print("c1 ");
		}
	}
	
	static class Res02 implements AutoCloseable{
		
		public Res02() {
			System.out.print("k2 ");
		}
		
		@Override
		public void close() {
			System.out.print("c2 ");
		}
	}


	public static void main(String[] args) {
		
	/*
	 * Bei mehreren Ressourcen in einem try-w-r
	 * 
	 * Die close Methode werden in der umgekehrten Reihenfolge augerufen.
	 * 
	 * Ausgaben here k1 k2 c2 c1 
	 */
		try (Res01 r = new Res01();
				Res02 r2 = new Res02()) {
			
		} 
		
		
	}
	
}
