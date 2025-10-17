// Folha 4.1
// Exercício 1

/**
 * Date class
 */
class Date {
	/**
	 * Day
	 */
	private int day;
	/**
	 * Month
	 */
	private int month;
	/**
	 * Year
	 */
	private int year;

	/**
	 * Checks the validity of the date
	 *
	 * @param day   Day
	 * @param month Month
	 * @param year  Year
	 * @return validity
	 */
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

	/**
	 * Date class constructor
	 *
	 * @param day   Day
	 * @param month Month
	 * @param year  Year
	 */
	public Date(int day, int month, int year) {
		assert (dateIsValid(day, month, year));
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Transforms Date class to a String
	 *
	 * @return String of the Date class
	 */
	public String toString() {
		String[] months = {
				"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
				"outubro", "novembro", "dezembro"
		};

		String string = day + " de " + months[month - 1] + " de " + year;
		return string;
	}

	/**
	 * Compares 2 dates
	 *
	 * @param date Date
	 * @return -1 if the first date comes first,
	 *         0 if they are the same date,
	 *         1 if the first date comes last
	 */
	public int compareTo(Date date) {
		if (this.year > date.year)
			return 1;
		if (this.year < date.year)
			return -1;

		if (this.month > date.month)
			return 1;
		if (this.month < date.month)
			return -1;

		if (this.day > date.day)
			return 1;
		if (this.day < date.day)
			return -1;

		return 0;
	}
}

public class DateWithClasses {
	public static void main(String[] args) {
		Date date1 = new Date(20, 10, 1975);
		Date date2 = new Date(1, 4, 1975);
		System.out.println(date1);
		System.out.println(date2);
		if (date1.compareTo(date2) == -1)
			System.out.println("A primeira data vem antes da segunda.");
		else if (date1.compareTo(date2) == 0)
			System.out.println("A primeira e a segunda data são iguais");
		else if (date1.compareTo(date2) == 1)
			System.out.println("A primeira data vem depois da segunda.");
	}
}
