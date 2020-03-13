package wdh;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollections {

	public static void main(String[] args) {
		
//		fill(new ArrayList<>()); // exc
//		fill(new HashSet<>());	// exc
//		fill(new PriorityQueue<>());	// exc
		
//		Collection<Integer> c1 = fill(Collections.synchronizedCollection(new ArrayList<>())); // exc
		
		System.out.println("ConcurrentSkipListSet");
		fill(new ConcurrentSkipListSet<Integer>()); // 12,13,14
		
		System.out.println("CopyOnWriteArrayList");
		fill(new CopyOnWriteArrayList<Integer>()); // 12,13
		
		System.out.println("ArrayBlockingQueue");
		fill(new ArrayBlockingQueue<Integer>(3)); // 12,13,14
		
		System.out.println("-------");

		int capacity = 3;
		BlockingQueue<Integer> bl = new ArrayBlockingQueue<Integer>(capacity); // FIFO
		boolean resultAdd = bl.add(4);
		System.out.println("1. add: " + resultAdd);
		
		boolean resultOffer = bl.offer(5);
		System.out.println("2. offer: " + resultOffer);
		
		try {
			bl.put(6); // void
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("3. : " + bl); // [4, 5, 6]
		
		try {
			boolean offerResult2 = bl.offer(1, 2, TimeUnit.SECONDS);
			System.out.println("4. offerResult2: " + offerResult2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("5. queue: " + bl); 
		
		try {
			bl.add(444); // exc - full
		} catch (IllegalStateException e) {
			System.out.println("6. add hat eine Exc geworfen: full queu");
		}
		
		runRemovingThread(bl);
		
		try {
			System.out.println("----- versuche ein weiteres Element in der queu zu speichern ");
			bl.put(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("7. queue: " + bl); //[5, 6, 8]
		
		Integer poll = bl.poll();
		System.out.println("8. poll: " + poll); // 5
		
		System.out.println("9. queue: " + bl); //[6, 8]
		
		try {
			Integer take = bl.take();							// take (block)
			System.out.println("10. take: " + take); // 6
			System.out.println("11. take: " + bl.take()); // 8
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("12. queue: " + bl); //[]
		
		try {
			bl.remove();
		} catch (Exception e) {
			System.out.println("Exc - queue ist leer");
		}
		
		try {
			Integer poll2 = bl.poll(2, TimeUnit.SECONDS);
			System.out.println("13. poll: " + poll2); // null
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	static void runRemovingThread(BlockingQueue<Integer> queue) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable<Integer> task = () -> {
			Thread.sleep(2000);
			System.out.println("----- entferne das nachste Element");
			return queue.remove();
		};
		
		service.submit(task);
		
		service.shutdown();
	}
	
	
	static Collection<Integer> fill(Collection<Integer> coll) {
		coll.add(12);
		coll.add(13);
		
		Iterator<Integer> it = coll.iterator();
		
		coll.add(14);
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		return coll;
	}
	
}
