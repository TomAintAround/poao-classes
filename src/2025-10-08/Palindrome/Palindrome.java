// Folha 3
// Exercício 3

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "aeiouoea";
		if (isPalindrome(input)) {
			System.out.println(input + " é um palíndrome");
		} else {
			System.out.println(input + " não é um palíndrome");
		}
		scanner.close();
	}

	public static boolean isPalindrome(String input) {
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
