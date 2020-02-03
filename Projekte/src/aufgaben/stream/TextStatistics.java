package aufgaben.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;

class CombinedTextStatisctics extends TextStatistics {
	
	private TextStatistics statisticsA,  statisticsB;
	
	public CombinedTextStatisctics(TextStatistics statisticsA, TextStatistics statisticsB) {
		super("");
		this.statisticsA = statisticsA;
		this.statisticsB = statisticsB;
	}

	@Override
	public int getCountChars() {
		return statisticsA.getCountChars() + statisticsB.getCountChars();
	}

	@Override
	public int getCountSpecialChars() {
		return statisticsA.getCountSpecialChars() + statisticsB.getCountSpecialChars();
	}

	@Override
	public int getCountLetters() {
		return statisticsA.getCountLetters() + statisticsB.getCountLetters();
	}

	@Override
	public Optional<String> getMaxWord() {
		String s1 = statisticsA.getMaxWord().get();
		String s2 = statisticsB.getMaxWord().get();
		return s1.compareTo(s2) > 0 ? Optional.of(s1) : Optional.of(s2);
	}

	@Override
	public Optional<String> getLongestWord() {
		String s1 = statisticsA.getLongestWord().get();
		String s2 = statisticsB.getLongestWord().get();
		return s1.length() > s2.length() ? Optional.of(s1) : Optional.of(s2);
	}
}

public class TextStatistics {
	
	private final String text;
	
	public TextStatistics(String text) {
		this.text = text;
	}
	
	public int getCountChars() {
		return text.length();
	}
	public int getCountSpecialChars() {
		
//		int count = 0;
//		
//		for (int i = 0; i < text.length(); i++) {
//			char ch = text.charAt(i);
//			if (Character.isLetterOrDigit(ch)) {
//				count ++;
//			}
//		}
//		return count;
		
//		int count = 0;
//		
//		for (char ch : text.toCharArray()) {
//			if (Character.isLetterOrDigit(ch)) {
//				count ++;
//			}
//		}
//		return count;
		return (int)text.chars()
				.filter(ch -> !Character.isLetterOrDigit(ch) )
				.count();
		
		
//		String[] strip = text.split(" ");
//		return strip.length;
	}
	public int getCountLetters() {
		return (int)text.chars().filter(Character::isLetter).count();
	}
	public Optional<String> getMaxWord() {
		
		return Arrays.stream(text.split(" ")).max(Comparator.naturalOrder());
		
	}
	public Optional<String> getLongestWord() {
		
		ToIntFunction<String> keyExtractor = new ToIntFunction<String>() {
			public int applyAsInt(String value) {
				return value.length();
			}
		};
//		return Arrays.stream(text.split(" ")).max(Comparator.comparingInt(keyExtractor));
		
		return Arrays.stream(text.split(" ")).max(Comparator.comparingInt(String::length));
		
	}

	public static void main(String[] args) {
		
		TextStatistics stats = new TextStatistics("Hallo Welt !");
		
		System.out.println("count chars: " + stats.getCountChars()); // 12
		System.out.println("count special chars: " + stats.getCountSpecialChars()); // 1
		System.out.println("count letters: " + stats.getCountLetters()); // 9
		System.out.println("max word: " + stats.getMaxWord().get()); // Welt
		System.out.println("max word: " + stats.getLongestWord().get()); // Hallo
		
		
		
		/*
		 * A2
		 */
		String[] input = {
				"3 Welt",
				"1 2 Hallo"
		};
		
		TextStatistics idt = new TextStatistics("");
		
		BiFunction<TextStatistics, String, TextStatistics> acc = (statistics, str) -> {
			TextStatistics newStatistics = new TextStatistics(str);
			
			return new CombinedTextStatisctics(statistics, newStatistics);
		};
		
		BinaryOperator<TextStatistics> cmb = CombinedTextStatisctics::new;
		
		stats = Arrays.stream(input).reduce(idt, acc, cmb);
		
		System.out.println("count chars: " + stats.getCountChars()); // 15
		System.out.println("count special chars: " + stats.getCountSpecialChars()); // 3
		System.out.println("count letters: " + stats.getCountLetters()); // 9
		System.out.println("max word: " + stats.getMaxWord().get()); // Welt
		System.out.println("max word: " + stats.getLongestWord().get()); // Hallo
		
		
	}
	
}
