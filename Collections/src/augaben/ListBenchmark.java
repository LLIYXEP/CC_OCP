package augaben;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BenchmarkAddFirst {
	
	public List<String> testAddFirst(String[] strArr) {
		LinkedList<String> strList = new LinkedList<String>();
		long result = 0;
		long start = System.currentTimeMillis();
		for (String string : strArr) {
			strList.add(0,string);
			result += System.currentTimeMillis() % start;
//			System.out.println(System.currentTimeMillis());
		}
		System.out.println("Time = " + result + " msec");
		return strList;
		//Time = 73307456 msec
		//Time = 1253343 msec
	}
	
}

public class ListBenchmark {

	public static void main(String[] args) {
		
		String[] arr1 = new String[100000];
		
		for (int i = 0; i < 100000; i++) {
			arr1[i] = "Pret";
		}
				
		BenchmarkAddFirst banch = new BenchmarkAddFirst();
		
		banch.testAddFirst(arr1);
	}
	
}
