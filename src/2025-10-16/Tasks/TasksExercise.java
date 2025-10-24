// Folha 4.1
// Exercício 5

import java.util.ArrayList;
import java.util.Arrays;

class Date {
	private int day;
	private int month;
	private int year;

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

	public Date(int day, int month, int year) {
		assert (dateIsValid(day, month, year));
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

enum TaskState {
	Incomplete, InProgress, Complete
}

class Task {
	private String name;
	private Date deadline;
	private TaskState state;

	public Task(String name, Date deadline, TaskState state) {
		this.name = name;
		this.deadline = deadline;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return deadline;
	}

	public TaskState getTaskState() {
		return state;
	}

	public String toString() {
		return "(" + name + ", " + deadline + ", " + state + ")";
	}
}

class TaskList {
	private ArrayList<Task> taskList;

	public TaskList() {
		taskList = new ArrayList<>();
	}

	public void addTask(Task task) {
		taskList.add(task);
	}

	public void removeTask(Task task) {
		taskList.remove(taskList.indexOf(task));
	}

	public ArrayList<Task> overdueTasks(Date referenceDate) {
		ArrayList<Task> overdue = new ArrayList<Task>();
		for (Task task : taskList) {
			boolean taskIncomplete = !task.getTaskState().equals(TaskState.Complete);
			boolean taskAfterDue = task.getDate().compareTo(referenceDate) == 1;
			if (taskIncomplete && taskAfterDue)
				overdue.add(task);
		}

		return overdue;
	}

	public void deleteCompleteTasks() {
		ArrayList<Task> toRemove = new ArrayList<>();
		for (Task task : taskList) {
			if (task.getTaskState().equals(TaskState.Complete))
				toRemove.add(task);
		}

		for (Task task : toRemove) {
			taskList.remove(task);
		}
	}

	public String toString() {
		return Arrays.toString(taskList.toArray());
	}
}

public class TasksExercise {
	public static void main(String[] args) {
		Date date1 = new Date(20, 10, 2005);
		Date date2 = new Date(20, 10, 2006);
		Task task1 = new Task("primeira", date1, TaskState.Incomplete);
		Task task2 = new Task("segunda", date2, TaskState.InProgress);
		TaskList taskList = new TaskList();
		taskList.addTask(task1);
		taskList.addTask(task2);

		System.out.println(taskList);
		taskList.deleteCompleteTasks();
		System.out.println(taskList);
		Date referenceDate = new Date(1, 4, 2006);
		System.out.println(taskList.overdueTasks(referenceDate));
	}
}
