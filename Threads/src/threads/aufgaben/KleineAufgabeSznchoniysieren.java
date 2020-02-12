package threads.aufgaben;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KleineAufgabeSznchoniysieren {
	
//	static class Printer extends Thread {
//		private char ch;
//		private int chrsProZeile;
//		private int zeilen;
//		
//		public Printer(char ch, int numb, int zeilen) {
//			super();
//			this.ch = ch;
//			this.chrsProZeile = numb;
//			this.zeilen = zeilen;
//		}
//		
//		public void run() {	
//			for (int i = 0; i < zeilen; i++) {
//				synchronized (System.out) {
//					for (int j = 0; j < chrsProZeile; j++) {
//						System.out.print(ch);
//					}
//					System.out.println();
//				}
//			}
//		}
//		
//
//	}
	
	static class Printer extends Thread {
		private int countZeilen;
		private String textZeile;
		
		public Printer(char ch, int numb, int zeilen) {
			this.countZeilen = zeilen;
			
			String textZeile = Stream.generate(() -> String.valueOf(ch))
								.limit(numb)
								.collect(Collectors.joining());
		}
		
		public void run() {	
			for (int i = 0; i < countZeilen; i++) {
				System.out.println(textZeile);	
			}
		}
		

	}

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		Printer p1 = new Printer('a', 10, 20);
		p1.start();
		
		/*
		 * A2
		 */
		Printer p2 = new Printer('*', 17, 30);
		p2.start();
		
		
		
	}
	
}
