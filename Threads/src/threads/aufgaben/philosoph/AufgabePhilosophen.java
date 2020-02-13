package threads.aufgaben.philosoph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class MyThreadd extends Thread {
	private Philosoph philosoph;

	public MyThreadd(Philosoph philosoph) {
		super();
		this.philosoph = philosoph;
	}


}

public class AufgabePhilosophen {

	public static void main(String[] args) throws InterruptedException {
		

		
		List<Philosoph> philosophen = Arrays.asList(
				new Philosoph("Sokrates"),
				new Philosoph("Platon"),
				new Philosoph("Decartes")
				);
		
		
		List<Object> gabeln = Stream.generate( Object::new )
							.limit(philosophen.size())
							.collect(Collectors.toList());
		
		/*
		 * Gabeln an Philosophen Platzen zuordnen
		 */
		for (int i = 0; i < philosophen.size(); i++) {
			Philosoph ph = philosophen.get(i);
			
			Object linkeGable = gabeln.get(i);
			
			int indexRechteGabel = i == philosophen.size()-1 ? 0 : i +1; // Letzte Philosoph bekommt gabel nummer 0
			Object rechteGable = gabeln.get(indexRechteGabel);
			
			ph.setLinkeGabel(linkeGable);
			ph.setRechteGabel(rechteGable);
		}
		
		/*
		 * Los geht es!
		 */
		List<Thread> threads = philosophen.stream()
				.map(ph -> new Thread(ph))
				.collect(Collectors.toList());
		
		threads.stream().forEach(Thread::start);
		
		
	}
	

	
}
