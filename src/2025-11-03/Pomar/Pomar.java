// Folha 5
// Exercício 1

import java.util.ArrayList;

abstract class Fruit {
	private String name;
	private double basePrice;

	public Fruit(String name, double basePrice) {
		this.name = name;
		this.basePrice = basePrice;
	}

	public abstract double getPrice();

	public int getQuantity() {
		return 0;
	}

	public double getWeight() {
		return 0;
	}

	public double getBasePrice() {
		return basePrice;
	}
}

class FruitUnit extends Fruit {
	private int quantity;

	public FruitUnit(String name, double basePrice, int quantity) {
		super(name, basePrice);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public double getPrice() {
		return getBasePrice() * quantity;
	}
}

class FruitWeight extends Fruit {
	private double weight;

	public FruitWeight(String name, double basePrice, double weight) {
		super(name, basePrice);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public double getPrice() {
		return getBasePrice() * weight;
	}
}

class Basket {
	private ArrayList<Fruit> basket;

	public Basket() {
		basket = new ArrayList<>();
	}

	public void addFruit(Fruit fruit) {
		basket.add(fruit);
	}

	public double getPrice() {
		double result = 0;
		for (Fruit fruit : basket) {
			result += fruit.getPrice();
		}
		return result;
	}

	public int getQuantity() {
		int result = 0;
		for (Fruit fruit : basket) {
			result += fruit.getQuantity();
		}
		return result;
	}

	public double getWeight() {
		double result = 0;
		for (Fruit fruit : basket) {
			result += fruit.getWeight();
		}
		return result;
	}
}

class PromotionalBasket extends Basket {
	private double discount;

	public PromotionalBasket(double discount) {
		super();
		this.discount = discount;
	}

	@Override
	public double getPrice() {
		return super.getPrice() * (1.0 - discount);
	}
}

public class Pomar {
	public static void main(String[] args) {
		Basket basket = new PromotionalBasket(0.75);
		basket.addFruit(new FruitWeight("Melon", 2, 2));
		basket.addFruit(new FruitWeight("Watermelon", 3.1, 2.5));
		basket.addFruit(new FruitUnit("Apple", 0.5, 10));
		basket.addFruit(new FruitUnit("Banana", 0.7, 6));
		System.out.println("Preço total: " + basket.getPrice() + "€");
		System.out.println("Quantidade: " + basket.getQuantity());
		System.out.println("Peso total: " + basket.getWeight() + " Kg");
	}
}
