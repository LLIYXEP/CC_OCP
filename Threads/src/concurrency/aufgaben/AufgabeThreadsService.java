package concurrency.aufgaben;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class AufgabeThreadsService {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		URL url = new URL("http://www.mieliestronk.com/corncob_lowercase.txt");
		URLConnection conn = url.openConnection();
		
		Runnable task = () -> {
			List<String> list = new ArrayList<String>();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
			    list = reader.lines().filter(s -> s.contains("t")).collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(list);
		};
		
		service.execute(task);
		
		
		
	URL url2 = new URL("http://www.mieliestronk.com/corncob_lowercase.txt");
	URLConnection conn2 = url2.openConnection();
		
	Callable<List<String>> task2 = () -> {
		List<String> list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn2.getInputStream(), StandardCharsets.UTF_8))) {
			list = reader.lines().filter(s -> s.contains("oo")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	};
	
	
	Future<List<String>> future = service.submit(task2);
	
	
	try {
		List<String> list = future.get();
		System.out.println(list);
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
		
	
	
	URL url3 = new URL("http://www.mieliestronk.com/corncob_lowercase.txt");
	URLConnection conn3 = url3.openConnection();
		
	Callable<List<String>> task3 = () -> {
		List<String> list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn3.getInputStream(), StandardCharsets.UTF_8))) {
			list = reader.lines().filter(s -> s.length() == 5).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	};
	
	
	Future<List<String>> future2 = service.submit(task3);
	
	
	try {
		List<String> list2 = future2.get();
		System.out.println(list2);
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
	
	
	
	URL url4 = new URL("http://www.mieliestronk.com/corncob_lowercase.txt");
	URLConnection conn4 = url4.openConnection();
		
	Callable<List<String>> task4 = () -> {
		List<String> list = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn4.getInputStream(), StandardCharsets.UTF_8))) {
			list = reader.lines().filter(s -> s.length() == 6).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	};
	
	
	Future<List<String>> future3 = service.submit(task4);
	
	
	try {
		List<String> list3 = future3.get();
		System.out.println(list3);
	} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	}
		
 
	service.shutdown();
		
	}
	
		
}
