// Folha 3
// Exercício 2

import java.util.Scanner;

public class NumberofVowels {
	public static void main(String[] args) {
		System.out.print("Escreva a sua frase: ");
		Scanner scanner = new Scanner(System.in);
		String phrase = scanner.nextLine();
		int vowelCounter = 0;
		for (int i = 0; i < phrase.length(); i++) {
			if (isVowel(phrase.charAt(i))) {
				vowelCounter++;
			}
		}
		System.out.println("Na sua frase existem " + vowelCounter + " vogais.");
		scanner.close();
	}

	public static boolean isVowel(char c) {
		String vowels = "aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙãẽĩõũÃẼĨÕŨâêîôûÂÊÎÔÛäëïöüÄËÏÖÜ";
		return vowels.indexOf(c) != -1;
	}
}
