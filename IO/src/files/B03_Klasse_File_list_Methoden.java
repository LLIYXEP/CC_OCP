package files;

import java.io.File;
import java.io.FileFilter;

public class B03_Klasse_File_list_Methoden {

	/*
	 * Methoden der Klasse 'File' sind nicht in der Prüfung
	 */
	public static void main(String[] args) {

		System.out.println("*** listRoots(): ");
		
		File[] roots = File.listRoots();
		
		for( File rt : roots ) {
			System.out.println(rt);
		}
		

		
		System.out.println("*** list(): ");
		
		File dir1 = new File("C:\\");
		
		String[] itemNames = dir1.list();
		
		for(String iName : itemNames) {
			System.out.println(iName);
		}
		
		
		System.out.println("*** listFiles(): ");
		
		File dir2 = new File("C:\\Windows");
		
		File[] items = dir2.listFiles();
		
		for(File path : items) {
			System.out.println(path);
		}
	
		
		System.out.println("*** nur Dateien mit listFiles(): ");
		
		for (File path : items) {
			if( path.isFile() ) {
				System.out.println(path);
			}
		}
		
		
		System.out.println("*** listFiles(FileFilter)");
		
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		};
		
		File[] subdirs = dir2.listFiles(filter);
		
		for (File subDir : subdirs) {
			System.out.println(subDir);
		}
		
	}

}
