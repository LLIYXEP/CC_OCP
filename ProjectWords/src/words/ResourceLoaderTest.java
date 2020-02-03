package words;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ResourceLoaderTest {

	@Test
	void test() {
		
		ResourceLoader instance = new ResourceLoader();
		
		List<String> words = instance.loadEnglischWords();
		
		int expected = 
	}

}
