package forkjoin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CounterV1 {

	private Path root;

	public CounterV1(String rootName) {
		this.root = Paths.get(rootName);
	}
	
	
	public int count() throws IOException {
		return (int)Files.walk(root).filter(path -> Files.isDirectory(path)).count();
	}
	
	
}
