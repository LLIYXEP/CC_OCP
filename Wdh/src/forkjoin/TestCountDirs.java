package forkjoin;

import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class RecursiveTaskDirCounter extends RecursiveTask<Integer> {
	
	protected Integer compute() {
		
		// falls die Aufgabe einfach genug ist: 
			// Aufgabe losen ( Ergebnis ermitteln)
		
		// falls die Aufgabee zu kompliziert ist:
			// in einfachere Aufgaben teilen und an den ForkJoinPool ubergeben
		
		return null;
	}
	
}

public class TestCountDirs {

	public static void main(String[] args) throws IOException {
		
//		CounterV1 c = new CounterV1("C:\\CCLauncher-Client-3");
//		System.out.println("1. " + c.count());
		
		ForkJoinPool pool = new ForkJoinPool();
		RecursiveTask<Integer> task = null;
		
		Integer count = pool.invoke(task);
		
		System.out.println("count: " + count);
		
	}
	
}
