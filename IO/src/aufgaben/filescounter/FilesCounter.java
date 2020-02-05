package aufgaben.filescounter;

import java.io.IOException;

public interface FilesCounter {

	int count (String extension) throws IOException;
	
}
