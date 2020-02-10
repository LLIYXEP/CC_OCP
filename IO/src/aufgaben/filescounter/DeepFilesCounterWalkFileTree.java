package aufgaben.filescounter;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DeepFilesCounterWalkFileTree implements FilesCounter {
	
//	private FileVisitor<Path> visitor = new FileVisitor<Path>() {
//		@Override
//		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//			return FileVisitResult.CONTINUE;
//		}
//		
//		@Override
//		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//			if(exc!=null) {
//				System.err.println("postVisitDirectory: " + exc);
//			}
//			
//			return FileVisitResult.CONTINUE;
//		}
//		
//		@Override
//		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//			return FileVisitResult.CONTINUE;
//		}
//		
//		@Override
//		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//			System.err.println("visitFileFailed: " + exc);
//			return FileVisitResult.CONTINUE;
//		}
//	};
	
	private class CountingFileVisitor extends SimpleFileVisitor<Path> {
		
		private int count;
		private String extension;
		
		CountingFileVisitor(String extension) {
			this.extension = extension;
		}

		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if(FileUtils.hasExtension(file, extension)) {
				count++;
			}
			return FileVisitResult.CONTINUE;
		};
		
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			System.err.println("visitFileFailed: " + exc);
			return FileVisitResult.CONTINUE;
		}
		
		public int getCount() {
			return count;
		}
	};
	
	private Path dir;

	public DeepFilesCounterWalkFileTree(String dirName) {
		dir = Paths.get(dirName);		
	}

	@Override
	public int count(String extension) throws IOException {
		if(!Files.isDirectory(dir)) {
			throw new NotDirectoryException(dir.toString());
		}
		
		CountingFileVisitor visitor = new CountingFileVisitor(extension);
		
		Files.walkFileTree(dir, visitor);
		
		
		return visitor.getCount();
	}

}
