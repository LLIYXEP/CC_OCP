package concurrency.aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RaceCar implements Runnable {
	private String name;
	private List<RaceCar> finish;
	private CyclicBarrier barrier;
	
	public void setBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	public RaceCar(String name, List<RaceCar> finish) {
		this.name = name;
		this.finish = finish;
	}

	public void run() {
		System.out.println(name + " started.");
		
		synchronized (finish) {
			finish.add(this);
			System.out.println(name + " finished.");
		}
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		return name;
	}
}

public class AufgabeCyclicBarier2 {

	public static void main(String[] args) throws InterruptedException {
		
		List<RaceCar> finish = new ArrayList<RaceCar>();
		
		List<RaceCar> autos = Arrays.asList(
				new RaceCar("VW", finish),
				new RaceCar("Audi", finish),
				new RaceCar("Opel", finish),
				new RaceCar("Mazda", finish)
				);
		
		Runnable showresult = () -> {
			for (int i = 0; i < finish.size(); i++) {
				System.out.println((i+1) + ". " + finish.get(i));
			}
		};
		
		CyclicBarrier barrier = new CyclicBarrier(autos.size(), showresult);
		
		autos.forEach(a -> a.setBarrier(barrier));
		
		ExecutorService service = Executors.newFixedThreadPool(autos.size());
		
		autos.forEach(service::submit);
		
		service.shutdown();
		
		
		
		
	}
	
}
