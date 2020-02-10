package aufgaben.filescounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeepFilesCounterWalk implements FilesCounter {

	private final Path dir; 
	
	public DeepFilesCounterWalk(String dirName) {
		this.dir = Paths.get(dirName);		
	}

	@Override
	public int count(String extension) throws IOException {

		if(!Files.isDirectory(dir)) {
			throw new NotDirectoryException(dir.toString());
		}
		
		return (int)Files.walk(dir) // Stream<Path>
							.filter(path -> Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS))
							.filter(file -> FileUtils.hasExtension(file, extension))
							.count();
		
	}

}
