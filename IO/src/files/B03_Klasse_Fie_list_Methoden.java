package files;

import java.io.File;
import java.io.FileFilter;

public class B03_Klasse_Fie_list_Methoden {

	public static void main(String[] args) {
		
		System.out.println("**** listRoots()");
		
		File[] roots = File.listRoots();
		
		for (File rt : roots) {
			System.out.println(rt); // C:\ D:\
		}
		
		
		System.out.println("**** list()");
		File dir1 = new File("C:\\");
		
		String[] list = dir1.list();
		for (String string : list) {
			System.out.println(string); // Program Files and other
		}
		
		
		System.out.println("******* listFiles()");
		
		File dir2 = new File("C:\\Windows");
		
		File[] listFiles = dir2.listFiles();
		
		for (File i : listFiles) {
			System.out.println(i);
		}
		
		
		
		System.out.println("******* isFile()");
		
		for (File path : listFiles) {
			if (path.isFile()) {
				System.out.println(path);
			}
		}
		
		
		System.out.println("******* listFiles(filter)");
		
		FileFilter filter = new FileFilter() {
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		};
		File[] listFiles2 = dir2.listFiles(filter);
		for (File file : listFiles2) {
			System.out.println(file);
		}
		
	}
	
}
