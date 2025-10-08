// Folha 1
// Exercício 6

import java.util.Scanner;

public class Combinations {
	public static int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public static int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

	public static void main(String[] args) {
		System.out.print("Insire n: ");
		Scanner scannerN = new Scanner(System.in);
		int n = scannerN.nextInt();
		System.out.print("Insire k: ");
		Scanner scannerK = new Scanner(System.in);
		int k = scannerK.nextInt();

		System.out.printf("%dC%d = %d", n, k, combinations(n, k));

		scannerN.close();
		scannerK.close();
	}
}
