package scurtu.com.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

//@TestInstance(Lifecycle.PER_METHOD)
public class QuestionBuilderTest {
	
	private final Answer a1 = new Answer("a1");
	private final Answer a2 = new Answer("a2");
	
	@Test
	void duplicateTopicsAreignored() {
		Question q = new Question.Builder()
				.text("Fragestellung")
				.topic("Basics")
				.topic("Basics")
				.answer( a1)
				.answer( a2)
				.build();
		
		assertEquals(1,  q.getTopics().size());
	}
	
	@Test
	void answerFailsOnDuplicateAnswer() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Question.Builder()
				.text("Fragestellung")
				.topic("Basics")
				.answer( a1)
				.answer( new Answer(a1.gettext(), a1.isCorrect()));
		});
		
		
	}

	@Test
	void testBuilderCanCreatequestion() {
		Question q = new Question.Builder()
			.text("Fragestellung")
			.topic("Basics")
			.answer( a1)
			.answer( a2)
			.build();
		
		assertNotNull(q);
	}
	
	@Test
	void testBuildWithComment() {
		String expected = "my comment";
		
		Question instance = new Question.Builder()
				.text("Frage")
				.topic("t1")
				.answer(a1)
				.answer(a2)
				.comment(expected)
				.build();
		
		assertEquals(expected,instance.getComment());
	}
	
	@Test
	void commentFailWithNull() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Question.Builder()
				.text("Frage")
				.topic("t1")
				.answer(a1)
				.answer(a2)
				.comment(null);
		});
	
	}
	
	@Test
	void testBuilderFailsWithAnswersLessThenTwo() {
		
		assertThrows(IllegalStateException.class, () -> {
			new Question.Builder()
			.text("Frage")
			.topic("Basics")
			.build();
		});	
	}
	
	@Test
	void testBuilderFailsWithEmptyTopicList() {
		
		assertThrows(IllegalStateException.class, () -> {
			new Question.Builder()
			.text("Frage")
			.answer(a1)
			.answer(a2)
			.build();
		});	
	}
	
	@Test
	void testBuilderFailsWithoutQuestionText() {
		
		assertThrows(IllegalStateException.class, () -> {
			new Question.Builder()
			.topic("Basics")
			.answer(a1)
			.answer(a2)
			.build();
		});	
	}
	
	@Test
	void testBuilderFailsIfAnyAnswerIsNull() {
		
		assertThrows(IllegalStateException.class, () -> {
			new Question.Builder()
			.text("Frage")
			.topic("Basics")
			.answer(a1)
			.answer(null)
			.build();
		});	
	}
	
	@Test
	void testBuilderFailsIfAnyTopicIsNull() {
		
		assertThrows(IllegalStateException.class, () -> {
			new Question.Builder()
			.text("Frage")
			.topic(null)
			.answer(a1)
			.answer(a2)
			.build();
		});	
	}
	
	
	
}
