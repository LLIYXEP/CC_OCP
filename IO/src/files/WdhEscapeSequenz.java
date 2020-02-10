package files;

public class WdhEscapeSequenz {

	public static void main(String[] args) {

		int s1 = "a".length();
		// int s2 = """.length(); // CF
		
		int s2 = "\"".length();
		System.out.println("s2 = " + s2); // 1
		
		int s3 = "\\".length();
		System.out.println("s3 = " + s3); // 1

	}

}
