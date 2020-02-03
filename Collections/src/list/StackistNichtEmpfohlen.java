package list;

import java.util.Stack;

import javax.print.DocFlavor.STRING;

public class StackistNichtEmpfohlen {

	public static void main(String[] args) {
		
		/*
		 * Bei der Klasse Stack liegt der HEAD rechts
		 */
		Stack<String> stack = new Stack<>();
		stack.push("unter");
		System.out.println("1: " + stack); //[unter]
		
		stack.push("mitte");
		System.out.println("2: " + stack); // [unter, mitte]
		
		stack.add("oben");
		System.out.println("3: " + stack); // [unter, mitte, oben]
		
		System.out.println(stack.peek()); // oben
		System.out.println(stack.pop()); // oben
		System.out.println(stack.pop()); // mitte
		System.out.println(stack.pop()); // unter
		
		System.out.println(stack.pop()); // EmptyStackException
		
	}
	
}
