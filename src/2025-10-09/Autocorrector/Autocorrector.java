// Folha 3
// Exercício 10

public class Autocorrector {
	public static void main(String[] args) {
		String phrase = "diaa euuu fuy passsear sinseranente nãu sey mais sério";
		String[] phraseSplit = phrase.split(" ");
		String[] dict = {
				"dia", "eu", "fui", "passear", "sinceramente", "não", "sei", "mais", "sério"
		};

		System.out.println("Sugestões:");
		for (String word : phraseSplit) {
			if (dictContains(dict, word))
				continue;

			System.out.print(word + ": ");
			for (String dictWord : dict) {
				if (checkFirstLetters(word, dictWord) && differentChars(word, dictWord) <= 2
						&& word.length() <= dictWord.length() + 2) {
					System.out.print(dictWord + " ");
				}
			}
			System.out.println();
		}
	}

	public static boolean dictContains(String[] dict, String word) {
		for (String dictWord : dict) {
			if (dictWord.equals(word))
				return true;
		}
		return false;
	}

	public static boolean checkFirstLetters(String word1, String word2) {
		String word1Start = word1.substring(0, 2);
		String word2Start = word2.substring(0, 2);
		return word1Start.equals(word2Start);
	}

	public static int differentChars(String word1, String word2) {
		int numDifferentChars = 0;
		for (int i = 2; i < word1.length() && i < word2.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				numDifferentChars++;
		}
		return numDifferentChars;
	}
}
