package scurtu.com.quiz;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class QuestionTest {
	
	private final Answer a1 = new Answer("a1");
	private final Answer a2 = new Answer("a2");
	
	@Test
	void testQuestionHasCompositionToTopicList() {
		Question instance = new Question.Builder()
				.text("frage")
				.answer(a1)
				.answer(a2)
				.topic("basics")
				.build();
		
		List<String> topics = instance.getTopics();
		
		topics.add("Hallo Welt");
		
		assertEquals(1, instance.getTopics().size());
	}
	
	@Test
	void testQuestionHasNotSharableAnswerList() {
		Question instance = new Question.Builder()
				.text("frage")
				.answer(a1)
				.answer(a2)
				.topic("basics")
				.build();
		
		List<Answer> answers = instance.getAnswers();
		
		answers.clear();
		
		assertEquals(2,  instance.getAnswers().size());
	}
	
	@Test
	void defaultCommentIsEmptyString() {
		Question instance = new Question.Builder()
				.text("Frage")
				.topic("t1")
				.answer(a1)
				.answer(a2)
				.build();
		
		assertEquals("",instance.getComment());
	}
	
}
