package files;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class B11_Files_Attribute {
	
	static Path testSource;
	
	static {
		Path src = Paths.get("abc.txt").toAbsolutePath();
		try {
			testSource = Files.copy(src, src.getParent().resolve("buchstaben"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
//		simpleMethods();
//		time();
		attributes();
		
	}
	
	static void attributes() throws IOException {
		
		System.out.println("****** Attributes");
		
		System.out.println("Datei: " + testSource);
		
		System.out.println("Mit BasicFileAttributes");
		BasicFileAttributes basicAtts = Files.readAttributes(testSource, BasicFileAttributes.class);
		System.out.println("size " + basicAtts.size());
		System.out.println("isDirectory " + basicAtts.isDirectory());
		System.out.println("isRegularFile " + basicAtts.isRegularFile());
		System.out.println("creationTime " + basicAtts.creationTime());
		System.out.println("lastAccessTime " + basicAtts.lastAccessTime());
		System.out.println("lastModifiedTime " + basicAtts.lastModifiedTime());
		
		DosFileAttributes dosAtts = null;   // DosFileAttributes extends BasicFileAttributes
		PosixFileAttributes posixAtts = null; // PosixFileAttributes extends BasicFileAttributes
		
		System.out.println("Mit get Attributes");
		Object sizeObj = Files.getAttribute(testSource, "basic:size");
		System.out.println("basic:size - " + sizeObj);
		
		sizeObj = Files.getAttribute(testSource, "basic:size");
		System.out.println("basic:size - " + sizeObj);
		
//		System.out.println(Files.getAttribute(testSource, "dos:isHidden")); //  EXC
		System.out.println("dos:hidden - " + Files.getAttribute(testSource, "dos:hidden"));   // false
		
		Files.setAttribute(testSource, "dos:hidden", true);
		
		System.out.println("dos:hidden - " + Files.getAttribute(testSource, "dos:hidden"));   // true
		
	}
	
	static void time() throws IOException {
		
		System.out.println("***** Zeit - Eigenschaften");
		System.out.println(" ** getLastModifiedTime - setLastModifiedTime");
		
		/*
		 * FileTime -  getLastModifiedTime
		 * 
		 * path - setLastModifiedTime
		 */
		
		System.out.println("Datei: " + testSource);
		
		FileTime lastModifiedTime = Files.getLastModifiedTime(testSource);
		System.out.println("getLastModifiedTime: " + lastModifiedTime); // 2020-02-07T07:56:00.218765Z
		
		FileTime time = FileTime.from(0, TimeUnit.DAYS);
		Files.setLastModifiedTime(testSource, time);
		lastModifiedTime = Files.getLastModifiedTime(testSource);
		System.out.println("getLastModifiedTime: " + lastModifiedTime);  // 1970-01-01T00:00:00Z
		
		System.out.println("Zeit mit BasicFile Attributes View");
		
		BasicFileAttributeView view = Files.getFileAttributeView(testSource, BasicFileAttributeView.class);
		
		FileTime lastModifiedTime2 = FileTime.from(Instant.now().plusSeconds(200));
		FileTime lastAccessTime = null;
		FileTime createTime = null;
		view.setTimes(lastModifiedTime2, lastAccessTime, createTime);
		
		lastModifiedTime = Files.getLastModifiedTime(testSource);
		System.out.println("getLastModifiedTime: " + lastModifiedTime);  
		
		BasicFileAttributes atts = view.readAttributes();
		System.out.println("last access time: " + atts.lastAccessTime());
		System.out.println("creation time: " + atts.creationTime());
	}

	static void simpleMethods() throws IOException {
		
		System.out.println("Datei: " + testSource);
		
		boolean result;
		result = Files.isRegularFile(testSource);
		System.out.println("isRegularFile: " + result);
		
		long size = Files.size(testSource);
		
		System.out.println("size: " + size);
		
		boolean executable = Files.isExecutable(testSource);
		System.out.println("isExecutable: " + executable);
		
		boolean hidden = Files.isHidden(testSource);
		System.out.println("isHidden: " + hidden);
		
		boolean readable = Files.isReadable(testSource);
		System.out.println("isReadable: " + readable);
		
		boolean writable = Files.isWritable(testSource);
		System.out.println("isWritable: " + writable);
		
		boolean symbolik = Files.isSymbolicLink(testSource);
		System.out.println("isSymbolicLink: " + symbolik);
		
		
		
	}
	
}
