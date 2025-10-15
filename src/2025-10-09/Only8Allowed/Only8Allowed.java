// Folha 3
// Exercício 6

import java.util.Scanner;

public class Only8Allowed {
	public static void main(String[] args) {
		System.out.println("Insire a sua frase: ");
		Scanner scanner = new Scanner(System.in);
		String phrase = scanner.nextLine();
		String[] phraseSplit = phrase.split(" ");
		String result = "";

		for (String word : phraseSplit) {
			if (moreThan2a(word)) {
				result += word + " ";
			}
		}
		System.out.println("Palavras com mais de 2 'a's:");
		System.out.println(result);

		scanner.close();
	}

	public static boolean moreThan2a(String word) {
		if (word.indexOf("a") != word.lastIndexOf("a")) {
			return true;
		} else {
			return false;
		}
	}
}
