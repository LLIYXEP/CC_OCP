package scurtu.com.quiz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerTest {

	@Test
	void answerConstructorCanSetValueCorrect() {
		Answer instance = new Answer("Antwort - Text", false);
		assertFalse(instance.isCorrect());
		
		instance = new Answer("Antwort - Text", true);
		assertTrue(instance.isCorrect());
	}
	
	@Test
	void answerConstructorCanSetValueOfText() {
		String expected = "answer - text";
		Answer instance = new Answer(expected, true);
		assertEquals(expected, instance.gettext());
	}
	
	@Test
	void answerWithNullTextIsNotPossible() {
		assertThrows(IllegalArgumentException.class, () -> new Answer(null));
	}

}
