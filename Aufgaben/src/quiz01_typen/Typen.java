package quiz01_typen;

import java.util.ArrayList;
import java.util.List;

public class Typen {
	
	public static void main(String[] args) {
		
		Answer q1a1 = new Answer("Exception", false);
		Answer q1a2 = new Answer("IOException", false);
		Answer q1a3 = new Answer("Error", false);
		Answer q1a4 = new Answer("ArithmeticException", true);
		
		List<Answer> answers1 = new ArrayList<>();
		
		answers1.add(q1a1);
		answers1.add(q1a2);
		answers1.add(q1a3);
		answers1.add(q1a4);
		
		Question q1 = new Question("Exception", 
				"What is a RuntimeException?", 
				answers1, 
				"Komment here"
				);
		
		System.out.println(q1);
	}
	


}
