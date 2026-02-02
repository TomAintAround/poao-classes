import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Student implements Comparable<Student> {
	private String name;
	private int[] grades;

	public Student(String name, int[] notas) {
		this.name = name;
		this.grades = notas;
	}

	public double getAverage() {
		double media = 0;
		for (int grade : grades) {
			media += grade;
		}
		return media / grades.length;
	}

	public int compareTo(Student student) {
		return (student.getAverage() - getAverage() > 0) ? -1 : 1;
	}

	public String toString() {
		return name + ": " + getAverage();
	}
}

class Class {
	private List<Student> students;

	public Class() {
		students = new ArrayList<>();
	}

	public void add(Student student) {
		students.add(student);
	}

	public void rearrangeClass() {
		Collections.sort(students);
	}

	public String toString() {
		String result = "[ ";
		for (Student student : students) {
			result += student.toString() + ", ";
		}
		return result + " ]";
	}
}

public class StudentManagement {
	public static void main(String[] args) {
		Class turma = new Class();
		turma.add(new Student("João", new int[] { 0, 4, 19, 15 }));
		turma.add(new Student("Tomás", new int[] { 20, 20, 19, 16 }));
		turma.add(new Student("Marco", new int[] { 15, 11, 5, 14 }));
		System.out.println(turma);
		turma.rearrangeClass();
		System.out.println(turma);
	}
}
