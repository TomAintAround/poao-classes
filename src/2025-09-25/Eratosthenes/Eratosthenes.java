// Folha 2
// Exercício 4

public class Eratosthenes {
	public static boolean[] getPrimes(int limit) {
		limit++;
		boolean[] primes = new boolean[limit];
		for (int i = 0; i < limit; i++) {
			primes[i] = true;
		}
		primes[0] = false;
		primes[1] = false;

		for (int i = 0; i < limit; i++) {
			if (primes[i] == false) {
				continue;
			}
			for (int j = i + i; j < limit; j += i) {
				primes[j] = false;
			}
		}
		return primes;
	}

	public static void printPrimes(boolean[] primes) {
		for (int i = 0; i < primes.length; i++) {
			System.out.printf("%d: ", i);
			if (primes[i]) {
				System.out.print("is prime\n");
			} else {
				System.out.print("is not prime\n");
			}
		}
	}

	public static void main(String[] args) {
		int limit = 100;
		boolean[] primes = getPrimes(limit);
		printPrimes(primes);
	}
}
