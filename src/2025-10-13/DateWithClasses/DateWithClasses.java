// Folha 4.1
// Exercício 1

import java.util.Scanner;

class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		assert (day >= 1 && day <= 31);
		assert (month >= 1 && day <= 12);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		String[] months = {
				"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
				"outubro", "novembro", "dezembro"
		};

		String string = day + " de " + months[month - 1] + " de " + year;
		return string;
	}
}

public class DateWithClasses {
	public static void main(String[] args) {
		System.out.print("Digite a data: ");
		Scanner scanner = new Scanner(System.in);
		String dateString = scanner.nextLine();
		String[] dataArray = dateString.split("/");
		int day = Integer.parseInt(dataArray[0]);
		int month = Integer.parseInt(dataArray[1]);
		int year = Integer.parseInt(dataArray[2]);
		Date date = new Date(day, month, year);
		System.out.println(date);
		scanner.close();
	}
}
