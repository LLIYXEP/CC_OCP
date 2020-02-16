package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class My1 {

	public static void main(String[] args) {
		
		NameList nameList = new NameList();
		nameList.add("fisrt");
		
		class MyThread extends Thread {
			@Override
			public void run() {
				System.out.println(nameList.removeFirst());
			}
		}
		
		MyThread myThread = new MyThread();
		myThread.setName("one");
		myThread.start();
		
		MyThread myThread2 = new MyThread();
		myThread2.start();
		
		
	}
	
	static class NameList {
		
		private List<String> list = Collections.synchronizedList(new ArrayList<>());
		
		public void add(String name) {
			list.add(name);
		}
		
		public synchronized String removeFirst() {
			if (list.size() > 0) {
				return list.remove(0);
			}
			return null;
		}
		
	}
	
}
