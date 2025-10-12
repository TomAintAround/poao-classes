// Folha 3
// Exercício 4

import java.util.Scanner;

public class ConcatP {
	public static void main(String[] args) {
		System.out.print("Insire a sua palavra: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += input.charAt(i);
			if (i != input.length() - 1 && isVowel(input.charAt(i)) && isVowel(input.charAt(i + 1))) {
				result += 'p';
			}
		}

		System.out.println("Resultado: " + result);
		scanner.close();
	}

	public static boolean isVowel(char c) {
		String vowels = "aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙãẽĩõũÃẼĨÕŨâêîôûÂÊÎÔÛäëïöüÄËÏÖÜ";
		return vowels.indexOf(c) != -1;
	}
}
