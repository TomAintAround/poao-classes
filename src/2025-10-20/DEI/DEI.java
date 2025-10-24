/done with their job/ Folha 4.2

// Exercício 1

/**
 * Person class
 */
class Person {
	/**
	 * Person's name
	 */
	private String name;
	/**
	 * Person's number
	 */
	private int number;

	/**
	 * Constructor of the Person class
	 *
	 * @param name   Name
	 * @param number Number
	 */
	public Person(String name, int number) {
		this.name = name;
	}

	/**
	 * @return Person's number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return Person communicating
	 */
	public String communicate() {
		return name + " está a comunicar";
	}
}

/**
 * Student class
 */
class Student extends Person {
	/**
	 * Constructor of the Student class
	 *
	 * @param name   Name
	 * @param number Number
	 */
	public Student(String name, int number) {
		super(name, number);
	}

	/**
	 * @return student's mission
	 */
	public String mission() {
		return "aprender";
	}

	/**
	 * @return student's info
	 */
	public String toString() {
		return "O aluno com o número de aluno " + getNumber() + " tem uma missão de " + mission();
	}
}

/**
 * Teacher class
 */
class Teacher extends Person {
	/**
	 * Constructor of the Teacher class
	 *
	 * @param name   Name
	 * @param number Typed number
	 */
	public Teacher(String name, int number) {
		super(name, number);
	}

	/**
	 * @return Teacher's mission
	 */
	public String mission() {
		return "ensinar";
	}

	/**
	 * @return Teacher's info
	 */
	public String toString() {
		return "O docente com o número mecanográfico " + getNumber() + " tem uma missão de " + mission();
	}
}

public class DEI {
	public static void main(String[] args) {
		Student student = new Student("Tomás", 5);
		Teacher teacher = new Teacher("Pedro", 24);

		System.out.println(student);
		System.out.println(teacher);
		System.out.println(student.communicate());
		System.out.println(teacher.communicate());
	}
}
