package scurtu.com.prufung;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;





public class Testas extends Thread {

	public static void main(String[] args)  {
		
		new Thread() { 
			public void run() {
				System.out.println(121212);
			}
		 }.start();


		
	}
		
}
