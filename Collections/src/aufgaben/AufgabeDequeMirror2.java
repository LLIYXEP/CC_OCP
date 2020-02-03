package aufgaben;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

class Mirror2 {
	private Deque<Character> chars = new ArrayDeque<Character>();
	
	
	public Mirror2() {
		chars.add('|');
	}

	public void add(char ch) {
		chars.addFirst(ch);
		chars.addLast(ch);
	}
	
	public boolean isEmpty() {
		return chars.size() == 1;
	}
	
	public void remove() {
		chars.removeFirst();
		chars.removeLast();
	}

	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		for (char character : chars) {
//			sb.append(character);
//		}
//		return sb.toString();
		
		return chars.stream().map(String::valueOf).collect(Collectors.joining());
	}
	
}

public class AufgabeDequeMirror2 {

	public static void main(String[] args) {
		
		Mirror2 m = new Mirror2();
		
		for (char ch = 'a'; ch < 'g'; ch++) {
			m.add(ch);
			System.out.println(m);
		}
		
		System.out.println("--------------------------");
		
		while( !m.isEmpty() ) {
			System.out.println(m);
			m.remove();
		}
		
	}
	
}
