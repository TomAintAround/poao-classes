// Folha 3
// Exercício 9

public class ComplexWords {
	public static void main(String[] args) {
		String[] words = {
				"15",
				"a",
				"passeio",
				"teu",
				"fura",
				"cão",
				"ateu",
				"furacão",
				"dado",
				"sol",
				"mar",
				"fim",
				"marfim",
				"soldado",
				"ajuda",
				"programar",
		};
		boolean[] correctWords = new boolean[words.length];

		for (int firstWordIndex = 0; firstWordIndex < words.length; firstWordIndex++) {
			for (int secondWordIndex = firstWordIndex + 1; secondWordIndex < words.length; secondWordIndex++) {
				String mixedWord = words[firstWordIndex] + words[secondWordIndex];
				String reversedWord = words[secondWordIndex] + words[firstWordIndex];

				for (int i = 0; i < words.length; i++) {
					if (i == firstWordIndex || i == secondWordIndex) {
						continue;
					}

					if (words[i].equals(mixedWord) || words[i].equals(reversedWord)) {
						correctWords[i] = true;
					}
				}
			}
		}

		for (int i = 0; i < words.length; i++) {
			if (correctWords[i]) {
				System.out.println(words[i]);
			}
		}
	}
}
