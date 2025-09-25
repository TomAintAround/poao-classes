import java.util.Scanner;

public class Methods {
	public static int soma(int num1, int num2) {
		return num1 + num2;
	}

	public static int subtrair(int num1, int num2) {
		return num1 - num2;
	}

	public static int multiplicar(int num1, int num2) {
		return num1 * num2;
	}

	public static double dividir(int num1, int num2) {
		return num1 / num2;
	}

	public static void main(String[] args) {
		System.out.print("Insire o primeiro número: ");
		Scanner scanner1 = new Scanner(System.in);
		int num1 = scanner1.nextInt();
		System.out.print("Insire o segundo número: ");
		Scanner scanner2 = new Scanner(System.in);
		int num2 = scanner2.nextInt();

		System.out.printf("A soma entre o número %d e %d é %d.\n", num1, num2, soma(num1, num2));
		System.out.printf("A subtração entre o número %d e %d é %d.\n", num1, num2, subtrair(num1, num2));
		System.out.printf("A multiplicação entre o número %d e %d é %d.\n", num1, num2, multiplicar(num1, num2));
		System.out.printf("A divisão entre o número %d e %d é %f.\n", num1, num2, dividir(num1, num2));

		scanner1.close();
		scanner2.close();
	}
}
