package words;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ResourceLoaderTest {

	@Test
	void testLoadEnglishWords() {
		
		List<String> words = ResourceLoader.loadEnglishWords();
		
		int expected = 58110;
		int actual = words.size();
		
		assertEquals(expected, actual);
	}

	@Test
	void testLoadPasswords() {
		
		List<String> passwords = ResourceLoader.loadPasswords();
		
		int expected = 10000;
		int actual = passwords.size();
		
		assertEquals(expected, actual);
	}
	
}
