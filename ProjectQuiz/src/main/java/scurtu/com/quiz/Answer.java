package scurtu.com.quiz;


public class Answer {

	private final boolean correct;
	private final String text;

	public Answer(String text) {
		this(text, false);
	}

	public Answer(String text, boolean correct) {
		if (text == null) {
			throw new IllegalArgumentException("Answer text must be not null");
		}
		
		this.correct = correct;
		this.text = text;
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Answer)) {
			return false;
		}
		
		Answer a2 = (Answer) obj;
		return  text.equals(a2.text) && correct == a2.correct;
	}

	public boolean isCorrect() {
		return correct;
	}

	public String gettext() {
		return text;
	}

	
	
}
