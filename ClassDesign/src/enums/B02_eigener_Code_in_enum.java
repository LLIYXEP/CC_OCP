package enums;

public class B02_eigener_Code_in_enum {
	
	enum Element{
		ERDE(),
		LUFT,
		FEUER(123),
		WASSER; // <- Semikolon achten
		
		/*
		 * Alle Konstruktoren sind private!
		 */
		Element() {}; // implizit private
		private Element(int x) {}
//		public Element(byte b) {};	// CF
		
		/*
		 * Weitere Inhalte wie in jeder 'normalen' Klasse
		 */
		private int x;
		
		public int getX() {
			return x;
		}
		
		@Override
		public String toString() {
			return name().toLowerCase();
		}
	
	} // end of enum

	public static void main(String[] args) {
		
		System.out.println(Element.FEUER.getX());
		
	}
	
}
