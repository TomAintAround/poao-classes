// Folha 3
// Exercício 7

import java.util.Scanner;

public class Dates {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String date = scanner.nextLine();
		String[] dateSplit = date.split("/");
		int monthNum = Integer.parseInt(dateSplit[1]);
		String[] months = {
				"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
				"outubro", "novembro", "dezembro"
		};

		System.out.println(dateSplit[0] + " de " + months[monthNum - 1] + " de " + dateSplit[2]);

		scanner.close();
	}
}
