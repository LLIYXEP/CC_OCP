package concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B09_ExecutorService_starten_beenden {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor(); // Service erzeugen und dabei die Strategie der Threadverwaltung festlegen
		
		Runnable command = () -> System.out.println("run");
		
		// Eigene Logik dem Service zum verteilen an den THreads ubergeben
		service.execute(command); // async
		service.execute(command); // async
		service.execute(command); // async
		service.execute(command); // async
		service.execute(command); // async
		
		// Service herunterfahren (versuchen)
//		service.shutdown(); //async
		
		// Service herunterfahren (versuchen)
		List<Runnable> registriertAberNichtGestartet = service.shutdownNow(); //async
		System.out.println("nicht aktivierte Aufgaben: " + registriertAberNichtGestartet.size());
		
		System.out.println("main");
		
		
		
	}
	
}
