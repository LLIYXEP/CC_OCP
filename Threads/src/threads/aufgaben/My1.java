package threads.aufgaben;


public class My1 {

	public static void main(String[] args) throws InterruptedException {

		Resource.i = 5;
		MyThread th1 = new MyThread();
		th1.setName("one");
		MyThread th2 = new MyThread();
		th1.start();
		th2.start();
		th1.join();
		th2.join();
		System.out.println(Resource.i);
		
	}	
}
class MyThread extends Thread {
	Resource resource;
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			new Resource().changeI();
			Resource.changeStaticI();
		}
	}
}

class Resource {
	static int i;
	
	public synchronized static void changeStaticI() {
		i++;
	}
	
	public synchronized void changeI() {
		i++;
	}
}