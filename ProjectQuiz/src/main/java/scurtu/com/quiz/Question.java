package scurtu.com.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	public static class Builder {
		private Question q = new Question();

		public Builder text(String text) {
			q.text = text;
			return this;
		}

		public Builder topic(String topic) {
			if (!q.topics.contains(topic)) {
				q.topics.add(topic);
			}
			return this;
		}

		public Builder answer(Answer answer) {
			if (q.answers.contains(answer)) {
				throw new IllegalArgumentException("duplicate answer: " + answer);
			}
			q.answers.add(answer);
			return this;
		}

		public Question build() {
			if (q.answers.size() < 2) {
				throw new IllegalStateException("There must be at least two answers");
			}
			if (q.text == null) {
				throw new IllegalStateException("Question text must be defined");
			}
			if (q.topics.isEmpty()) {
				throw new IllegalStateException("Topic list must be not empty");
			}
			if (q.answers.contains(null)) {
				throw new IllegalStateException("Answer must be not null");
			}
			if (q.topics.contains(null)) {
				throw new IllegalStateException("Topic must be not null");
			}
			return q;
		}

		public Builder comment(String comment) {
			if (comment == null) {
				throw new IllegalArgumentException("Comment must be not null");
			}
			q.comment = comment;
			return this;
		}

	}
	
	
	private final List<Answer> answers = new ArrayList<Answer>();
	
	private final List<String> topics = new ArrayList<String>();
	
	private String text;
	private String comment = "";
	
	private Question() {};

	public List<String> getTopics() {
		return new ArrayList<String>(topics);
	}


	public String getText() {
		return text;
	}

	public List<Answer> getAnswers() {
		return new ArrayList<Answer>(answers);
	}

	public String getComment() {
		return comment;
	}

}
