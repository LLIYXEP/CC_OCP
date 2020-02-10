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
	
	static final Path testSource;
	
	static {
		Path src = Paths.get("abc.txt").toAbsolutePath();
		try {
			testSource = Files.copy(src, src.getParent().resolve("buchstaben"), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		simpleMethods();
		time();
		attributes();
	}
	
	static void attributes() throws IOException {
		System.out.println("*** Attributes");
		
		System.out.println("Datei: " + testSource);
		
		System.out.println("* mit BasicFileAttributes: ");
		
		BasicFileAttributes basicAtts = Files.readAttributes(testSource, BasicFileAttributes.class);
		System.out.println("size: "  + basicAtts.size());
		System.out.println("isDirectory: "  + basicAtts.isDirectory());
		System.out.println("isRegularFile: "  + basicAtts.isRegularFile());
		System.out.println("creationTime: "  + basicAtts.creationTime());
		System.out.println("lastAccessTime: "  + basicAtts.lastAccessTime());
		System.out.println("lastModifiedTime: "  + basicAtts.lastModifiedTime());
		
		DosFileAttributes dosAtts = null; // DosFileAttributes extends BasicFileAttributes
		PosixFileAttributes posixAtts = null; // PosixFileAttributes extends BasicFileAttributes
	
		System.out.println("* mit getAttribute: ");
		Object sizeObj = Files.getAttribute(testSource, "size");
		System.out.println("size = " + sizeObj);
		
		sizeObj = Files.getAttribute(testSource, "basic:size");
		System.out.println("basic:size = " + sizeObj);
		
		// hie unterstützte namen für DosFileAttributes:
		// https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/DosFileAttributeView.html
		System.out.println( "dos:hidden = " +  Files.getAttribute(testSource, "dos:hidden") ); // false (exam)
		Files.setAttribute(testSource, "dos:hidden", true); // exam
		System.out.println( "dos:hidden = " + Files.getAttribute(testSource, "dos:hidden") ); // true (exam)
	}
	
	static void time() throws IOException {
		System.out.println("*** Zeit-Eigenschaften");
		
		System.out.println("* Zeit mit getLastModifiedTime, setLastModifiedTime");
		
		/*
		 *  FileTime getLastModifiedTime(Path)
		 *  
		 *  Path setLastModifiedTime(Path, FileTime)
		 */
		
		System.out.println("Datei: " + testSource);
		FileTime lastModified = Files.getLastModifiedTime(testSource);
		System.out.println("last modified: " + lastModified); //  2020-02-05T07:58:37.053111Z
		
		lastModified = FileTime.from(0, TimeUnit.DAYS);
		Files.setLastModifiedTime(testSource, lastModified); // last modified ändern
		
		lastModified = Files.getLastModifiedTime(testSource);
		System.out.println("last modified: " + lastModified);  // 1970-01-01T00:00:00Z
		
		
		System.out.println("* Zeit mit BasicFileAttributeView ");
		
		BasicFileAttributeView view = Files.getFileAttributeView(testSource, BasicFileAttributeView.class);
		
		FileTime lastModifiedTime = FileTime.from(Instant.now());
		FileTime lastAccessTime = null;
		FileTime createTime = null;
		view.setTimes(lastModifiedTime, lastAccessTime, createTime);
		
		lastModified = Files.getLastModifiedTime(testSource);
		System.out.println("last modified: " + lastModified);  // 2020-02-07T08:29:03.663304Z
		
		
		BasicFileAttributes atts = view.readAttributes();
		System.out.println( "last access: " + atts.lastAccessTime() );
		System.out.println( "created: " + atts.creationTime());
	}
	
	static void simpleMethods() throws IOException {
		
		System.out.println("*** einfache Methoden");
		
		System.out.println("Datei: " + testSource);
		boolean result;
		
		result = Files.isRegularFile(testSource);
		System.out.println("isRegularFile: " + result);  // true
		
		long size = Files.size(testSource);
		System.out.println("size: " + size); // 3 (in byte)
		
		result = Files.isExecutable(testSource);
		result = Files.isHidden(testSource);
		result = Files.isReadable(testSource);
		result = Files.isWritable(testSource);

	}

}

