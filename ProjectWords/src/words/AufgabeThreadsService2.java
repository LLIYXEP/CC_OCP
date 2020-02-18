package words;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

class TaskCountWords implements Callable<Integer>{
	private List<String> words;
	private Predicate<String> predicate;

	public TaskCountWords(List<String> words, Predicate<String> predicate) {
		super();
		this.words = words;
		this.predicate = predicate;
	}

	@Override
	public Integer call() throws Exception {
		
		return (int)words.stream().filter(predicate).count();
	}
	
}

public class AufgabeThreadsService2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		a2a3a4();
//		a5();
		a6a7();
	}
	
	public static void a6a7() throws InterruptedException, ExecutionException {
		System.out.println("**** A6");
		
		List<String> words = ResourceLoader.loadEnglishWords();
		System.out.println("words: " + words.size()); //58110
		
		final int countTasks = 50;
		final int subListSize = words.size() / countTasks;
		
		List<Callable<Integer>> tasks = new ArrayList<>();
		for (int i = 0, von = 0; i < countTasks; i++, von += subListSize) {
			System.out.print("Task " + i);
			
			int bis = von + subListSize;
			// unschon, muss noch geandert werden fur die Letzte Task
			if (i == countTasks - 1) {
				bis = words.size();
			}
			
			
			System.out.println(" " + von + " .. " + bis);
			List<String> subList = words.subList(von, bis);
			Callable<Integer> task = new TaskCountWords(subList, w -> w.length() == 5);
			tasks.add(task);
			
		}
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		List<Future<Integer>> futures = service.invokeAll(tasks);
		int summe = 0;
		for (Future<Integer> future : futures) {
			summe += future.get();
		}
		
		System.out.println("Worte mit Langer 5: " + summe);
		
	}
	
	
	
	
	
	
	public static void a5() {
		System.out.println("**** A5");
		
		List<String> words = ResourceLoader.loadEnglishWords();
		System.out.println("words: " + words.size()); //58110
		
		Callable<Long> taskCount = () -> words.stream().filter(w -> w.length() == 5).count();
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Future<Long> future = service.submit(taskCount);
		
		try {
			Long count = future.get();
			System.out.println("Worter mit Lange 5: " + count);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
	}

	public static void a2a3a4() {
		
		List<String> words = ResourceLoader.loadEnglishWords();
		System.out.println("words: " + words.size()); //58110
		
		AtomicInteger result1 = new AtomicInteger();
		Runnable task1 = () -> {
			int count = 0;
			for (String w : words) {
				if (w.indexOf('t') != -1) {
					count++;
				}
			}
			result1.set(count);;
		};
		
		
		Callable<Integer> task2 = () -> {
			int count = 0;
			for (String w : words) {
				if (w.contains("oo")) {
					count++;
				}
			}
			return count;
		};
		
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Future<?> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		
		
		
		try {
			future1.get();
			System.out.println("result1: " + result1);
			
			System.out.println("Worter mit oo: " + future2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
		service.shutdown();
		
		
		
//		a2(words);
		
	}
	

		
}
