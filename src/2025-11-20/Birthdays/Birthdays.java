import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

class Date implements Serializable {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		assert (dateIsValid(day, month, year));
		this.day = day;
		this.month = month;
		this.year = year;
	}

	private boolean dateIsValid(int day, int month, int year) {
		if (day < 1)
			return false;
		if (month < 1 || month > 12)
			return false;

		boolean leapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if (month == 2) {
			if (leapYear && day > 29)
				return false;
			else if (!leapYear && day > 28)
				return false;
			return true;
		}

		int[] monthsDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (day > monthsDays[month - 1])
			return false;

		return true;
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

class Birthday implements Serializable {
	private String name;
	private Date date;

	public Birthday(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String toString() {
		return name + ", " + date;
	}
}

public class Birthdays {
	public static void main(String[] args) {
		LinkedList<Birthday> birthdays = new LinkedList<>();

		File input = new File("input.txt");
		if (input.exists() && input.isFile()) {
			try {
				FileReader fileReader = new FileReader(input);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					String[] lineSplit = line.split(",");
					String[] dateSplit = lineSplit[1].split("/");
					int day = Integer.parseInt(dateSplit[0]);
					int month = Integer.parseInt(dateSplit[1]);
					int year = Integer.parseInt(dateSplit[2]);
					Date date = new Date(day, month, year);
					Birthday birthday = new Birthday(lineSplit[0], date);
					birthdays.add(birthday);
					System.out.println(birthday);
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("O ficheiro de entrada não foi encontrado");
			} catch (IOException e) {
				System.out.println("Erro a ler o ficheiro de entrada");
			}
		}

		File output = new File("output.obj");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(output);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(birthdays);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro a abrir o ficheiro de saída");
		} catch (IOException e) {
			System.out.println("Erro a escrever no ficheiro de saída");
		}
	}
}
