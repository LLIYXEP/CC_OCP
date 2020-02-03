package streams;

import java.util.stream.Stream;

public class Tmp {

	public static void main(String[] args) {
		
		System.out.println(Stream.of("Freitag", "FREITAG", "FrEiTaG").allMatch(s -> s.equalsIgnoreCase("freitag")));
		
	}
	
}
