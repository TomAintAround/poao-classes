import java.util.Scanner;

public class SomaDigitos {
	public static void main(String[] args) {
		System.out.print("Escreva um número: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int tmp = num;
		int soma = 0;
		while (tmp > 0) {
			soma += tmp % 10;
			tmp /= 10;
		}
		System.out.printf("A soma dos dígitos do número %d é %d.", num, soma);
		scan.close();
	}
}
