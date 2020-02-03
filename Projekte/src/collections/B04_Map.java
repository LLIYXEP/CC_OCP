package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class B04_Map {
	
	static Map<Integer, String> getWochenMap() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		map.put(4, "do");
		map.put(5, "fr");
		map.put(6, "sa");
		map.put(7, "so");
		
		return map;
	}

	public static void main(String[] args) {
		
//		forEach();
//		replaceAll();
//		marge();
//		computeIfAbsent();
//		computeIfPresent();
		compute();
		
	}
	
	static void compute() {
		System.out.println("****** merge");
		
		Map<Integer, String> map = getWochenMap();
		
		System.out.println("1. map: "+ map);	
		
		Integer key = 1;
		BiFunction<Integer, String, String> remappingFunction = (keyParam, oldValueParam) -> oldValueParam.toUpperCase();
		String s = map.compute(key, remappingFunction);
		System.out.println("2. map: "+ map);
		System.out.println(s);
		
	}
	
	
	static void computeIfPresent() {
		System.out.println("****** merge");
		
		Map<Integer, String> map = getWochenMap();
		
		BiFunction<Integer, String, String> remappingFunction = (keyParam, oldValueParam) -> oldValueParam.toUpperCase() ;
		
		System.out.println("1. map: "+ map);			//{1=mo, 2=di, 3=mi, 4=do, 5=fr, 6=sa, 7=so}
		String s = map.computeIfPresent(20, remappingFunction);
		System.out.println("2. map: "+ map);			//{1=mo, 2=di, 3=mi, 4=do, 5=fr, 6=sa, 7=so}
		System.out.println(s); // null
		
		s = map.computeIfPresent(1, remappingFunction);
		System.out.println("2. map: "+ map);			//{1=MO, 2=di, 3=mi, 4=do, 5=fr, 6=sa, 7=so}
		System.out.println(s); // MO
	}
	
	static void computeIfAbsent() {
		
		System.out.println("****** merge");
		
		/*
		 * V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
		 */
		
		Map<Integer, String> map = getWochenMap();
		
		Function<Integer, String> mappingFunction = key -> "kein Tag";
		
		System.out.println("1. map: "+ map);			//{1=mo, 2=di, 3=mi, 4=do, 5=fr, 6=sa, 7=so}
		String s = map.computeIfAbsent(20, mappingFunction);
		System.out.println("2. map: "+ map);			//{1=mo, 2=di, 3=mi, 20=kein Tag, 4=do, 5=fr, 6=sa, 7=so}
		System.out.println(s);							//kein Tag
		
		s = map.computeIfAbsent(1, mappingFunction);
		System.out.println("2. map: "+ map);			//map: {1=mo, 2=di, 3=mi, 20=kein Tag, 4=do, 5=fr, 6=sa, 7=so}
		System.out.println(s);							// mo
	}
	
	static void marge() {
		System.out.println("****** merge");
		
		/*
		 * V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
		 * 
		 * V oldValue = map.get(key);
			 V newValue = (oldValue == null) ? value :
			              remappingFunction.apply(oldValue, value);
			 if (newValue == null)
			     map.remove(key);
			 else
			     map.put(key, newValue);
		 */
		
		Map<Integer, String> map = getWochenMap();
		System.out.println("1: map " + map);
		
		/*
		 * Es gibt bereaits den eintrag "mo" fur den Key = 1
		 * 
		 * newValue fur den Key = 1 wird mitder remappingFunction berechnet
		 * 
		 * 	remappingFunction.apply(oldValue = "mo", value = "!!!") - > ergebniss hier: "mo!!!"
		 * 
		 * => newValue = "mo!!!"
		 * => alter Werd fur Key = 1 wird mit newValue ersetzt
		 */
		Integer key = 1;
		String value = "!!!";
		
		BiFunction<String, String, String> remappingFunction = ( oldValueParam, valueparam ) -> oldValueParam + valueparam;
		
		String s = map.merge(key, value, remappingFunction);
		
		System.out.println("newValue: " + s);
		System.out.println("1: map " + map);
		
		/*
		 *  Es gibt keinen Eintrag fur den Key = 20
		 */
		key = 20;
		value = "kein Wochentag";
		
		s = map.merge(key, value, remappingFunction);
		
		System.out.println("newValue: " + s);
		System.out.println("1: map " + map);
	}
	
	static void replaceAll() {
		System.out.println("******** replaceAll");
		
		/*
		 * void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
		 * 
		 * 
		 */
		
		Map<Integer, String> map = getWochenMap();
		
		BiFunction<Integer, String, String> function = (Integer key, String oldValue) -> {
			String newVlaue = oldValue.toUpperCase();
			return newVlaue;
		};
		map.replaceAll(function);
		
		System.out.println("2: " + map); // {1=MO, 2=DI, 3=MI, 4=DO, 5=FR, 6=SA, 7=SO}
	}
	
	static void forEach() {
		System.out.println("******** forEach");
		
		/*
		 * void forEach(BiConsumer<? super K, ? super V> action)
		 */
		
		Map<Integer, String> map = getWochenMap();
		
		BiConsumer<Integer, String> action = (a, b) -> System.out.println(a + ", " + b);
		map.forEach(action);
	}
	
}
