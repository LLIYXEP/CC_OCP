package aufgaben.filescounter;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.SimpleFormatter;

public class DeepFilesCounterWalkFileTree implements FilesCounter {
	
//	private FileVisitor<Path> visitor = new FileVisitor<Path>() {
//
//		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//			return FileVisitResult.CONTINUE;
//		}
//
//		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//			if (exc!=null) {
//				System.err.println("postVisitDirectory " + exc);
//			}
//			return FileVisitResult.CONTINUE;
//		}
//		
//		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//			return FileVisitResult.CONTINUE;
//		}
//		
//		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//			System.err.println("visitFileFailed " + exc);
//			return FileVisitResult.CONTINUE;
//		}
//	};
	
	
	private class CountingFileVisitor extends SimpleFileVisitor<Path> {
		
		private int count;
		private String extension;
		
		public CountingFileVisitor(String extension) {
			super();
			this.extension = extension;
		}
		
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			System.err.println("visitFileFailed " + exc);
			return FileVisitResult.CONTINUE;
		}
		
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (FileUtils.hasExtension(file, extension)) {
				count++;
			}
			return FileVisitResult.CONTINUE;
		}

		public int getCount() {
			return count;
		}
		
	};
	
	private final Path dir;

	public DeepFilesCounterWalkFileTree(String dirName) {
		dir = Paths.get(dirName);
	}

	@Override
	public int count(String extension) throws IOException {
		
		if (!Files.isDirectory(dir)) {
			throw new NotDirectoryException(dir.toString());
		}
		
		CountingFileVisitor visitor = new CountingFileVisitor(extension);
		
		Files.walkFileTree(dir, visitor);
		
		return visitor.getCount();
	}

}
