// Folha 1
// Exercício 8

import java.util.Scanner;

public class LSDReplication {
	public static void main(String[] args) {
		System.out.print("Insire o número máximo de dígitos: ");
		Scanner scanner = new Scanner(System.in);
		int digitsNum = scanner.nextInt();

		for (int digits = 1; digits <= digitsNum; digits++) {
			long upperLimit = (long) Math.pow(10, digits);
			long lowerLimit = (long) Math.pow(10, digits - 1);
			if (lowerLimit == 1)
				lowerLimit = 2;
			for (long num = lowerLimit; num < upperLimit; num++) {
				long squared = num * num;
				if (squared % upperLimit == num)
					System.out.printf("Possui: %d (%dx%d = %d)\n", num, num, num, squared);
			}
		}

		scanner.close();
	}
}
