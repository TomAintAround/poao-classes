import java.util.Scanner;

public class LSDReplication {
	public static void main(String[] args) {
		System.out.print("Insire o número máximo de dígitos: ");
		Scanner scanner = new Scanner(System.in);
		int digitsNum = scanner.nextInt();

		int limit = (int) Math.pow(10, digitsNum);
		for (int i = 2; i < limit; i++) {
			int squared = (int) Math.pow(i, 2);
			if (squared % limit == i)
				System.out.printf("Possui: %d (%dx%d = %d)\n", i, i, i, squared);
		}

		scanner.close();
	}
}
