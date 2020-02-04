package files;

import java.io.File;

public class B01_Pfade {

	public static void main(String[] args) {
		
		/*
		 * Absolute Pfade, Windows Notation
		 */
		
		String p1 = "C:\\Loca\\java";
		String p2 = "C:\\a\\b.txt";
		
		/*
		 * Absolute Pfade, Unix Notation
		 */
		
		String p3 = "/"; // root
		String p4 = "/a/b.txt"; // root
		
		/*
		 * Relative Pfadangaben werden relativ zu dem aktuellen Arbeitsverzeichnis gemacht
		 * 
		 * Das aktuelle Arbeitsverzeichnis ist das Verzeichnis, in dem das Kommandozeilentool (Konsole) geoffnet wird
		 * 
		 * Unter Eclipse ist das aktuelle Arbeitsverzeichnis standartmassig das Projektverzeichniss
		 */
		
		/*
		 * Relative Pfade, Windows Notation
		 */
		
		String p5 = "bin";
		String p6 = "src\\file\\txt";
		
		/*
		 * Relative Pfade, Unix Notation
		 */
		
		String p7 = "bin";
		String p8 = "src/file/txt";
		
		String p9 = "."; // das aktuelle Verzeichnis
		String p10 = ".."; // Parent
		
		/*
		 * Bsp
		 */
		
		String p11 = "../Generics/bin";
		String p12 = "D:\\Eclipse Projects OCP\\ocp_192316";
		
		String userHome = System.getProperty("user.home");
		System.out.println("user.home " + userHome);
		
		
	}
	
}
