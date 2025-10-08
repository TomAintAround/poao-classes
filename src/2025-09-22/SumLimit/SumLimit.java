// Folha 1
// Exercício 1

import java.util.Scanner;

public class SumLimit {
	public static void main(String[] args) {
		System.out.print("Insire o número limite: ");
		Scanner scanner = new Scanner(System.in);
		int limit = scanner.nextInt();

		int num = 1;
		for (int i = 2; num < limit; i++) {
			num += i;
		}
		System.out.printf("O número final é %d.\n", num);

		scanner.close();
	}
}
