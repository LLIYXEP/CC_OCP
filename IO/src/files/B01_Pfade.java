package files;

public class B01_Pfade {

	public static void main(String[] args) {

		/*
		 * Absolute Pfade, Windows Notation
		 */
		String p1 = "C:\\Local\\java";
		String p2 = "D:\\a\\b.txt";
		
		/*
		 * Absolute Pfade, Unix Notation
		 */
		String p3 = "/"; // root
		String p4 = "/a/b.txt"; 

		
		/*
		 * Relative Pfadangaben werden relativ zu dem aktuellen Arbeitsverzeichnis gemacht.
		 * 
		 * Das aktuelle Arbeitsverzeichnis ist das Verzeichnis, in dem das Kommandozeilentool 
		 * (Konsole) geöffnet (ausgeführt) wird.
		 * 
		 * Unter Eclipse ist das aktuelle Arbeitsverzeichnis standardmäßig das Projektverzeichnis
		 * 
		 */
		
		
		/*
		 * Relative Pfade, Windows Notation
		 */
		String p5 = "bin";
		String p6 = "src\\file.txt";
		
		
		/*
		 * Relative Pfade, Unix Notation
		 */
		String p7 = "bin";
		String p8 = "src/file.txt";
		
			
		/*
		 * Besondere Pfadangaben
		 */
		
		String p9 = "."; // das aktuelle Verzeichnis
		String p10 = ".."; // Parent-Verzeichnis
		
		
		/*
		 * Bsp.
		 */
		String p11 = "../Generics/bin";
		String p12 = "C:\\Users\\apatrin\\git\\ocp_192316\\Projekte\\Generics\\bin";

		
		String userHome = System.getProperty("user.home");
		System.out.println("user.home: " + userHome);
		
	}

}
