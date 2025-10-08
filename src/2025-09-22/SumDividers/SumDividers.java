// Folha 1
// Exercício 5

import java.util.Scanner;

public class SumDividers {
	public static int somarDivisores(int n) {
		int soma = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i != 0)
				continue;
			soma += i + (n / i);
		}
		return soma;
	}

	public static void main(String[] args) {
		System.out.print("Insire o número limite: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.print("Números perfeitos: ");
		for (int i = 3; i <= n; i++) {
			if (somarDivisores(i) == i)
				System.out.printf("%d ", i);
		}
		System.out.print("\n");

		scanner.close();
	}
}
