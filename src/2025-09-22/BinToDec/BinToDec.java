// Folha 1
// Exercício 2

import java.util.Scanner;

public class BinToDec {
	public static void main(String[] args) {
		System.out.print("Insire um número binário: ");
		Scanner scanner = new Scanner(System.in);
		int numBin = scanner.nextInt();

		int numDec = 0;
		int numTemp = numBin;
		int numZeros = 0;
		int numOnes = 0;
		for (int i = 0; numTemp > 0; i++) {
			int lastDigit = numTemp % 10;
			if (lastDigit == 0) {
				numZeros++;
			} else {
				numOnes++;
			}
			numDec += lastDigit * Math.pow(2, i);
			numTemp /= 10;
		}
		System.out.printf("Binário: %d\nNúmero de 0s: %d\nNúmero de 1s: %d\nDecimal: %d\n", numBin, numZeros, numOnes,
				numDec);

		scanner.close();
	}
}
