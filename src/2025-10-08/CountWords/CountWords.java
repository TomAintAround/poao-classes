// Folha 3
// Exercício 5

import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		System.out.print("Escreva a sua frase: ");
		Scanner scannerPhrase = new Scanner(System.in);
		String phrase = scannerPhrase.nextLine();
		System.out.print("Escreva a sua frase: ");
		Scanner scannerWord = new Scanner(System.in);
		String word = scannerWord.nextLine();

		int wordCounter = 0;
		String[] phraseArray = phrase.split(" ");
		for (String currentWord : phraseArray) {
			if (currentWord.equals(word)) {
				wordCounter++;
			}
		}

		System.out.println("A palavra aparece " + wordCounter + " vez/vezes");
		scannerPhrase.close();
		scannerWord.close();
	}
}
