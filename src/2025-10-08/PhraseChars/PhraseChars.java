// Folha 3
// Exercício 1

import java.util.Scanner;

public class PhraseChars {
	public static void main(String[] args) {
		System.out.print("Escreva a sua frase: ");
		Scanner scanner = new Scanner(System.in);
		String phrase = scanner.nextLine();
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) != ' ') {
				System.out.println("Char: " + phrase.charAt(i));
			}
		}
		scanner.close();
	}
}
