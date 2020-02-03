package generics;

import java.util.*;

/*
 * type inference operator (auch als Diamond-Operator bekannt)
 */
public class B13_Diamond_Operator {

	public static void main(String[] args) {
		
		/*
		 * Der Compiler ermittelt die notwendige
		 * Prametrisierung fur den Konstruktor Aufruf aus dem Kontext
		 */
		
		List<Integer> listA = new ArrayList<>();
		
		Map<Integer, List<Map<String, Double>>> mapA = new HashMap<>();
		
		// Ohne den Diamond- Operator kann der Code  deutlich langer werden
		Map<Integer, List<Map<String, Double>>> mapB = new HashMap<Integer, List<Map<String,Double>>>();
		
		useMap(new HashMap<>());
		
//		Map<> useMap = useMap(new HashMap<>());  // CF: <> links , <Integer, List<Map<String, Double>>> rechts
		Map<Integer, List<Map<String, Double>>> useMap2 = useMap(new HashMap<>()); 
		
		/*
		 * Exam:
		 */
		List<String> listX = new ArrayList<String>();
//		List<> listY = new ArrayList<String>(); // CF: <> links
		List listC = new ArrayList<String>();
		List listD = new ArrayList<>(); //// raw type links, rechts ArrayList<Object>
		
		
		
		
	}
	
	static Map<Integer, List<Map<String, Double>>> useMap(Map<Integer, List<Map<String, Double>>> map) {
		return map;
	}
}
