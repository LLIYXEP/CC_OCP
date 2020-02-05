package aufgaben.filescounter;

import java.io.IOException;

public class AufgabeFilesCounter {

	public static void main(String[] args) throws IOException {
		
		String extension = "txt";
//		String dirName = "C:\\local";
		String dirName = "C:\\Windows";  // 1 // Exc
		
		System.out.println("Flat suche mit Files.newDirectoryStream");
		testFilesCounterRealisation(new FlatFilesCounterV1(dirName), extension, dirName); // 1
		
		
		System.out.println("Deep Search mit Files.walk");
		try {
			testFilesCounterRealisation(new DeepFilesCounterV2(dirName), extension, dirName); // 53
		} catch (Exception e) {
			System.err.println("Fehler!!!: " + e);
		}
		
		System.out.println("Deep Search mit Files.WalkFileTree");
		testFilesCounterRealisation(new DeepFilesCounterWalkFileTree(dirName), extension, dirName); // 3
		
	}
	
	
	static void testFilesCounterRealisation(FilesCounter fc, String extension, String dirName) throws IOException {
		int count = fc.count(extension);
		System.out.println("1. count: " + count);
	}
	
	
}
