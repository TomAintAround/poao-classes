class Thought {
	public void message() {
		System.out.println("Aproxima-se a latada...");
	}
}

class Advice extends Thought {
	public void message() {
		System.out.println("-----------------");
		super.message();
		System.out.println("Mas atenção, há trabalhos para entregar...");
	}
}

public class Think {
	public static void main(String[] args) {
		Thought thought = new Thought();
		Advice exam = new Advice();
		thought.message();
		exam.message();
		thought = exam;
		thought.message();
	}
}
