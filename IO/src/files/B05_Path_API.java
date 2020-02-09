package files;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B05_Path_API {

	public static void main(String[] args) {
		
//		testEquals();
//		test_getNameCount_getName();
		test_getRoot_getParent_getFileName();
//		test_supath();
//		test_relativize();
//		test_resolve();
//		test_weitere();
	}
	
	static void	test_weitere() {
		System.out.println("***** nicht so Prufungsrelevant");
		
		Path path = Paths.get("a/b/./c/../d");
		System.out.println("path.normalize(): " + path.normalize()); //a\b\d
		System.out.println(path.getNameCount()); // 6
		System.out.println(path.subpath(1, 5)); // b\.\c\..
		System.out.println(path.toAbsolutePath()); // D:\Eclipse Projects OCP\CC_OCP\IO\a\b\.\c\..\d
		System.out.println(Paths.get(".").toAbsolutePath().normalize());
	}
	
	static void test_resolve() {
		System.out.println("***** resolve p1 ist absolut, p2 ist relative");
		
		Path p1 = Paths.get("C:\\Windows");
		System.out.println("p1 " + p1);
		Path p2 = Paths.get("Java/bin");
		System.out.println("p2 " + p2);
		
		Path p3 = p1.resolve(p2);
		System.out.println("p3 " + p3); // C:\Windows\Java\bin
		System.out.println("p4 " + p1.resolve("Java/bin")); // C:\Windows\Java\bin
		
		System.out.println();
		
		p1 = Paths.get("C:\\Windows");
		System.out.println("p1 " + p1);
		p2 = Paths.get("C:/Java/bin");
		System.out.println("p2 " + p2);
		
		p3 = p1.resolve(p2);
		System.out.println("p3 " + p3); // C:\Java\bin
		
	}
	
	static void test_relativize() {
		System.out.println("***** relativize");
		
		Path path = Paths.get("a/b/c/d");
		Path path2 = Paths.get("a/b/x/y");
		
		System.out.println("p1 " + path);
		System.out.println("p2 " + path2);
		/*
		 * Weg aus dem Verzeichnis y zum Verzeichnis d:
		 * 1. zu x wechseln ..
		 * 2. zu b wechseln ..
		 * 3. zu c wechseln /c
		 * 4. zu d wechseln /d
		 */
		
		
		Path relativize2 = path2.relativize(path);
		System.out.println(relativize2); // ..\..\c\d
		
		Path relativize = path.relativize(path2);
		System.out.println(relativize);
		
		path = Paths.get("/a/b");
		path2 = Paths.get("/a/x");
		
		System.out.println("p1 " + path);
		System.out.println("p2 " + path2);
		
		relativize = path2.relativize(path);
		System.out.println(relativize);
		
		path = Paths.get("C:/a/b");
		path2 = Paths.get("D:/a/x");
		
		System.out.println("p1 " + path);
		System.out.println("p2 " + path2);
		
//		relativize = path2.relativize(path);
//		System.out.println(relativize);   //IllegalArgumentException: 'other' has different root
		
		path = Paths.get("C:/a/b");
		path2 = Paths.get("a/x");
		
		System.out.println("p1 " + path);
		System.out.println("p2 " + path2);
		
//		relativize = path2.relativize(path); // IllegalArgumentException: 'other' is different type of Path
//		System.out.println(relativize);   
	}
	
	static void test_supath() {
		
		System.out.println("***** subpath");
		
		Path path = Paths.get("a/b/c/d");
//		path.subpath(1, 5); // Exc
		Path subpath = path.subpath(1, 3);
		System.out.println("subpath(1, 3) " + subpath); // b\c
	}
	
	static void test_getRoot_getParent_getFileName(){
		System.out.println("****getRoot getFileName getParent");
		
		Path path = Paths.get("a/b");
		
		System.out.println("path: " + path);
		
		Path root = path.getRoot();		
		System.out.println("getRoot() " + root); // null
		
		Path parent = path.getParent();
		System.out.println("getParent() " + parent);  // a
		
		Path fileName = path.getFileName(); // The file name is the farthest element fromthe root in the directory hierarchy.
		System.out.println("getFileName() " + fileName); // b
		
		
		System.out.println("absolute");
		path = Paths.get("C:\\a\\b");
		
		System.out.println("path: " + path);
		
		root = path.getRoot();		
		System.out.println("getRoot() " + root); // C:\
		
		parent = path.getParent();
		System.out.println("getParent() " + parent);  // a
		
		fileName = path.getFileName(); // The file name is the farthest element fromthe root in the directory hierarchy.
		System.out.println("getFileName() " + fileName); // b
	}
	
	static void test_getNameCount_getName() {
		
		System.out.println("getNameCount_getName");
		
		System.out.println("mit einem relativen Pfad");
		Path path = Paths.get("a/b", "c/d");
		
		System.out.println("path: " + path);
		
		int count = path.getNameCount();
		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			Path name = path.getName(i);
			System.out.println(i + " " + name); // 0 -> a, 1-> b
		}
		
		
		System.out.println("mit einem absoluten Pfad");
		path = Paths.get("C:\\a\\b", "c\\d");
		
		System.out.println("path: " + path);
		
		count = path.getNameCount();
		System.out.println(count);
		
//		Achtung! Wurzel (logischer Laufwerksname) ist nicht dabei
		for (int i = 0; i < count; i++) {
			Path name = path.getName(i);
			System.out.println(i + " " + name); // 0 -> a, 1-> b
		}
		
	}
	
	
	static void testEquals() {
		
		System.out.println("***** equals");
		
		Path p1 = Paths.get("a");
		Path p2 = Paths.get("a");
		
		System.out.println("p1" + p1);
		System.out.println("p2" + p2);
		System.out.println("p1 == p2" + (p1 == p2));
		System.out.println("p1.equals(p2) " + p1.equals(p2));
		
		System.out.println("***** ");
		
		p1 = Paths.get("a\\b\\c");
		p2 = Paths.get("a\\..\\a\\b\\c");
		
		System.out.println("p1 " + p1);
		System.out.println("p2 " + p2);
		System.out.println("p1 == p2 " + (p1 == p2));
		System.out.println("p1.equals(p2) " + p1.equals(p2));
		System.out.println("p1.equals(p2.normalize()) " + p1.equals(p2.normalize()));
		
		p1 = Paths.get("a/b/c");
		p2 = Paths.get("a/b", "c");
		
		System.out.println("p1 " + p1);
		System.out.println("p2 " + p2);
		System.out.println("p1 == p2 " + (p1 == p2));
		System.out.println("p1.equals(p2) " + p1.equals(p2));
		System.out.println("p1.equals(p2.normalize()) " + p1.equals(p2.normalize()));
		
		p1 = Paths.get("a/b/c");
		p2 = Paths.get("a/", "b/c");
		
		System.out.println("p1 " + p1);
		System.out.println("p2 " + p2);
		System.out.println("p1 == p2 " + (p1 == p2));
		System.out.println("p1.equals(p2) " + p1.equals(p2));
		System.out.println("p1.equals(p2.normalize()) " + p1.equals(p2.normalize()));
		
		
	}
	
}
