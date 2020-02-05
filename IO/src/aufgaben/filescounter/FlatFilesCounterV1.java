package aufgaben.filescounter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlatFilesCounterV1 implements FilesCounter{
	
	private final Path dir;

	public FlatFilesCounterV1(String dirName) {
		dir = Paths.get(dirName);
	}

	@Override
	public int count(String extension) throws IOException {
		
		if (!Files.isDirectory(dir)) {
			throw new NotDirectoryException(dir.toString());
		}
		
		DirectoryStream.Filter<Path> filter = path -> {
			if (!Files.isRegularFile(path)) {
				return false;
			}
			return FileUtils.hasExtension(path, extension);
		};
		
		int count = 0;
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(dir, filter)) {
			for (@SuppressWarnings("unused") Path path2 : ds) {
				count++;
			}
		} catch (Exception e) {
		}
		
		return count;
	}

	
	
}
