package designpatterns;
/*
 * Patter Builder: flexible Bilden komplexe Objekte. Beim bilden bestimmte Voraussetzungen Berücksichtigen (oder bestimmte Einstellungen vornehmen)
 */
public class Pattern_Builder {

	public static void main(String[] args) {
		
		/*
		 * Stringbuilder wurde mit Builder - Pattern entwicklet
		 */
		
		//normal:
		StringBuilder sb1 = new StringBuilder();
		sb1.append("a");
		sb1.append("b");
		sb1.insert(1,  " x ");
		String s1 = sb1.toString();
		System.out.println(s1);
		
		//verkettet: - сцепленный
		String sb2 = new StringBuilder()
			.append("a")		//set info
			.append("b")		//set info
			.insert(1,  " x ")	//set info
			.toString();		 // build
		
		System.out.println(sb2);
	}
	
}
