package generics;

import generics.Wdh01.Steckdose;

public class Wdh01 {
	
	static class  TV{}
	static class TVDE extends TV{}
	static class TVUK extends TV{}

	static class Steckdose<T extends TV> {
		T tv;
		void anschliesen(T tv) {
			this.tv = tv;
		}
	}

	public static void main(String[] args) {
		
		Steckdose<TV> sdTV = null;
		Steckdose<TVDE> sdDE = new Steckdose<TVDE>();
		Steckdose<TVUK> sdUK = null;
		
		/*
		 * 1. Kontrolle: Steckdose <= IS-A <= Steckdose		: OK
		 * 2. Kontrolle: <TVUK> <= ist nicht gleich <TVDE>	: CF
		 */
//		sdUK = sdEN;
		sdUK.anschliesen(new TVUK());
		
		/*
		 * 1. Kontrolle: Steckdose <= IS-A <= Steckdose		: OK
		 * 2. Kontrolle: <TV> <= ist nicht gleich <TVUK>	: CF
		 */
//		sdTV = sdDE;
		sdTV = new Steckdose<TV>();
		sdTV.anschliesen(new TVDE());
		sdTV.anschliesen(new TVUK());
		
		Steckdose<? extends TV> sd3;
		sd3 = sdTV; // 1: Steckdose <= IS-A <= Steckdose 2: <? extends TV> gleich <TV>
		
		sd3 = sdDE;	// 1: Steckdose <= IS-A <= Steckdose 2: <? extends TV> gleich <TVDE>
		sd3 = sdUK;
//		sd3.anschliesen(new TVDE()); // CF
		sd3.anschliesen(null);
		
		
		Steckdose<? super TVDE> sd4;
		
		sd4 = sdTV;
//		sd4 = sdUK; // CF
		sd4 = sdDE; 
		
		sd4.anschliesen(new TVDE()); 
//		sd4.anschliesen(new TVUK()); 	// CF 
//		sd4.anschliesen(new TV());		// CF 
	}
	
}
