package threads.aufgaben.philosoph;

import threads.MyThreadUtils;

/*
 * Achtung es ist nu ein Lernbeispiel!
 * Deadlick sollte man nicht programmieren!
 */

public class Philosoph implements Runnable {

	private String name;
	private Object linkeGabel, rechteGabel;
	

	public void setLinkeGabel(Object linkeGabel) {
		this.linkeGabel = linkeGabel;
	}

	public void setRechteGabel(Object rechteGabel) {
		this.rechteGabel = rechteGabel;
	}

	public Philosoph(String name) {
		this.name = name;
	}

	
	public void run() {
		/*
		 * Achtung! Deadlock moglich!
		 */
		while (true) {
			System.out.println(name + " denkt nach...");
			MyThreadUtils.pause(2);
			System.out.println(name + " hat Hunger");
			
			synchronized (linkeGabel) {
				System.out.println(name + " nimmt die linke Gabel");
				
				MyThreadUtils.pause(100); // erhoht die Wahrscheinlichkeit eines Deadlock
				
				synchronized (rechteGabel) {
					System.out.println(name + " nimmt die rechte Gabel");
					
					System.out.println(name + " isst...");
					MyThreadUtils.pause(5000);
					
					System.out.println(name + " legt die rechte Gabel ab");
				}
				System.out.println(name + " legt die linke Gabel ab");
			}
		}
	}
	
}
