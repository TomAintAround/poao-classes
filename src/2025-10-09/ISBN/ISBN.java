// Folha 3
// Exercício 8

import java.util.Scanner;

public class ISBN {
	public static void main(String[] args) {
		System.out.print("Introduza o ISBN: ");
		Scanner scanner = new Scanner(System.in);
		String isbn = scanner.nextLine();
		String[] isbnSplit = isbn.split("");
		int[] isbnDigits = new int[10];

		System.out.print("Valor inicial: ");
		for (int i = 0; i < isbnSplit.length; i++) {
			if (isbnSplit[i] != "X" || isbnSplit[i] != "x") {
				isbnDigits[i] = Integer.parseInt(isbnSplit[i]);
			} else {
				isbnDigits[i] = 10;
			}
			System.out.print(isbnDigits[i] + " ");
		}
		System.out.println();

		int[] s1 = new int[10];
		int[] s2 = new int[10];
		s1[0] = isbnDigits[0];
		System.out.print("Somas parciais (s1): " + s1[0]);
		for (int i = 1; i < s1.length; i++) {
			s1[i] = isbnDigits[i] + s1[i - 1];
			System.out.print(s1[i] + " ");
		}
		System.out.println();
		s2[0] = s1[0];
		System.out.print("Somas parciais (s2): " + s1[0]);
		for (int i = 1; i < s2.length; i++) {
			s2[i] = s1[i] + s2[i - 1];
			System.out.print(s2[i] + " ");
		}
		System.out.println();

		if (s2[9] % 11 == 0) {
			System.out.println("O ISBN dado é correto.");
		} else {
			System.out.println("O ISBN dado é incorreto");
		}

		scanner.close();
	}
}
