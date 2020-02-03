package aufgaben;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

class TextProcessor {
	
	Deque<String> deque = new ArrayDeque<String>();
	
	void add(String str) {
		deque.add(str);
	}

	@Override
	public String toString() {
		String result = "";
		for (String string : deque) {
			result += string;
		}
		return result;
	}

	boolean undo() {
		boolean result = false;
		if (deque.size() > 0) {
			deque.removeLast();
			result = true;
		}
		return result;
	}
	
	boolean redo() {
		
		return true;
	}
	
}

public class AufgabeDequeBrowserHistory {

	public static void main(String[] args) {
		
		TextProcessor p = new TextProcessor();
//		p.add("a");
//		p.add("b");
//		p.add("c");
//		
//		System.out.println(p); // abc
//		
//		System.out.println( p.undo() ); // true
//		System.out.println( p ); // ab
//		
//		System.out.println( p.undo() ); // true
//		System.out.println( p ); // a
//		
//		System.out.println( p.undo() ); // true
//		System.out.println( p ); //
//		
//		System.out.println( p.undo() ); // false
//		System.out.println( p ); // 
		
		System.out.println( p.redo() ); // true
		System.out.println( p ); // a
		
		System.out.println( p.redo() ); // true
		System.out.println( p ); // ab
		
		System.out.println( p.redo() ); // true
		System.out.println( p ); // abc
		
		System.out.println( p.redo() ); // false
		System.out.println( p ); // abc
		
		
		
	}
	
}
