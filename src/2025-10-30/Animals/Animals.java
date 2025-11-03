// Folha 4.2.2
// Exercício 1

class Animal {
	private String specie;
	private String origin;

	public Animal(String name, String origin) {
		this.specie = name;
		this.origin = origin;
	}

	public void move() {
		System.out.println(specie + " a deslocar-se.");
	}

	public String getSpecie() {
		return specie;
	}

	public String getOrigin() {
		return origin;
	}
}

class Mammal extends Animal {
	public Mammal(String name, String origin) {
		super(name, origin);
	}

	@Override
	public void move() {
		System.out.println("Mamífero, " + getSpecie() + ", " + getOrigin() + " a andar.");
	}
}

class Bird extends Animal {
	public Bird(String name, String origin) {
		super(name, origin);
	}

	@Override
	public void move() {
		System.out.println("Ave, " + getSpecie() + ", " + getOrigin() + " a voar.");
	}
}

class Reptile extends Animal {
	public Reptile(String name, String origin) {
		super(name, origin);
	}

	@Override
	public void move() {
		System.out.println("Réptil, " + getSpecie() + ", " + getOrigin() + " a rastejar.");
	}
}

class Fish extends Animal {
	public Fish(String name, String origin) {
		super(name, origin);
	}

	@Override
	public void move() {
		System.out.println("Peixe, " + getSpecie() + ", " + getOrigin() + " a nadar.");
	}
}

public class Animals {
	public static void main(String[] args) {
		Animal[] zoo = {
				new Mammal("Macaco", "Congo"),
				new Bird("Rouxinol", "Coimbra"),
				new Reptile("Cobra", "Amazónia"),
				new Fish("Tubarão", "Bermuda")
		};

		for (Animal animal : zoo) {
			animal.move();
		}
	}
}
