// Folha 4.2.2
// Exercício 3

class Product {
	private String description;
	private String origin;
	private double weightKg;
	private double vatRate;
	private double priceKg;

	public Product(String description, String origin, double weightKg, double vatRate, double priceKg) {
		this.description = description;
		this.origin = origin;
		this.weightKg = weightKg;
		this.vatRate = vatRate;
		this.priceKg = priceKg;
	}

	public String toString() {
		String description = "- Descrição: " + this.description + "\n";
		String origin = "- Origem: " + this.origin + "\n";
		String weight = "- Peso: " + this.weightKg + "\n";
		String vatRate = "- Taxa de IVA: " + this.vatRate + "\n";
		String priceKg = "- Preço/Kg: " + this.priceKg;
		return "Produto:\n" + description + origin + weight + vatRate + priceKg;
	}

	public String getDescription() {
		return description;
	}

	public String getOrigin() {
		return origin;
	}

	public double getWeightKg() {
		return weightKg;
	}

	public double getVatRate() {
		return vatRate;
	}

	public double getPriceKg() {
		return priceKg;
	}

	public double getFinalCost() {
		return priceKg * weightKg * (1.0 + vatRate);
	}
}

class Fresh extends Product {
	private double packagingProcessCost;

	public Fresh(String description, String origin, double weightKg, double vatRate, double priceKg,
			double packagingProcessCost) {
		super(description, origin, weightKg, vatRate, priceKg);
		this.packagingProcessCost = packagingProcessCost;
	}

	@Override
	public double getFinalCost() {
		return (getPriceKg() * getWeightKg() + packagingProcessCost) * (1.0 + getVatRate());
	}

	@Override
	public String toString() {
		String description = "- Descrição: " + getDescription() + "\n";
		String origin = "- Origem: " + getOrigin() + "\n";
		String weightKg = "- Peso: " + getWeightKg() + "\n";
		String vatRate = "- Taxa de IVA: " + getVatRate() + "\n";
		String priceKg = "- Preço/Kg: " + getPriceKg() + "\n";
		String packagingProcessCost = "- Custo do processo de embalamento: " + this.packagingProcessCost;
		return "Fresco:\n" + description + origin + weightKg + vatRate + priceKg + packagingProcessCost;
	}
}

class Transformed extends Product {
	private double grossWeightKg;
	private double avgTransformCostKg;

	public Transformed(String description, String origin, double weightKg, double vatRate, double priceKg,
			double grossWeightKg, double avgTransformCostKg) {
		super(description, origin, weightKg, vatRate, priceKg);
		this.grossWeightKg = grossWeightKg;
		this.avgTransformCostKg = avgTransformCostKg;
	}

	public double getGrossWeightKg() {
		return grossWeightKg;
	}

	public double getAvgTransformCostKg() {
		return avgTransformCostKg;
	}

	@Override
	public double getFinalCost() {
		return (grossWeightKg * avgTransformCostKg) * (1.0 + getVatRate());
	}

	@Override
	public String toString() {
		String description = "- Descrição: " + getDescription() + "\n";
		String origin = "- Origem: " + getOrigin() + "\n";
		String weightKg = "- Peso: " + getWeightKg() + "\n";
		String vatRate = "- Taxa de IVA: " + getVatRate() + "\n";
		String priceKg = "- Preço/Kg: " + getPriceKg() + "\n";
		String grossWeightKg = "- Peso bruto / Kg: " + this.grossWeightKg + "\n";
		String avgTransformCostKg = "- Custo médio do processo de transformação / Kg: " + this.avgTransformCostKg;
		return "Transformado:\n" + description + origin + weightKg + vatRate + priceKg + grossWeightKg
				+ avgTransformCostKg;
	}
}

class CannedGood extends Transformed {
	private double priceKgUsedProduct;

	public CannedGood(String description, String origin, double weightKg, double vatRate, double priceKg,
			double grossWeightKg, double avgTransformCostKg, double priceKgUsedProduct) {
		super(description, origin, weightKg, vatRate, priceKg, grossWeightKg, avgTransformCostKg);
		this.priceKgUsedProduct = priceKgUsedProduct;
	}

	@Override
	public double getFinalCost() {
		return (getGrossWeightKg() * getAvgTransformCostKg() + priceKgUsedProduct) * (1.0 + getVatRate());
	}

	@Override
	public String toString() {
		String description = "- Descrição: " + getDescription() + "\n";
		String origin = "- Origem: " + getOrigin() + "\n";
		String weightKg = "- Peso: " + getWeightKg() + "\n";
		String vatRate = "- Taxa de IVA: " + getVatRate() + "\n";
		String priceKg = "- Preço/Kg: " + getPriceKg() + "\n";
		String grossWeightKg = "- Peso bruto / Kg: " + getGrossWeightKg() + "\n";
		String avgTransformCostKg = "- Custo médio do processo de transformação / Kg: " + getAvgTransformCostKg()
				+ "\n";
		String priceKgUsedProduct = "- Preço/Kg do produto utilizado: " + this.priceKgUsedProduct;
		return "Transformado:\n" + description + origin + weightKg + vatRate + priceKg + grossWeightKg
				+ avgTransformCostKg + priceKgUsedProduct;
	}
}

class Frozen extends Transformed {
	public Frozen(String description, String origin, double weightKg, double vatRate, double priceKg,
			double grossWeightKg, double avgTransformCostKg) {
		super(description, origin, weightKg, vatRate, priceKg, grossWeightKg, avgTransformCostKg);
	}

	@Override
	public String toString() {
		String description = "- Descrição: " + getDescription() + "\n";
		String origin = "- Origem: " + getOrigin() + "\n";
		String weightKg = "- Peso: " + getWeightKg() + "\n";
		String vatRate = "- Taxa de IVA: " + getVatRate() + "\n";
		String priceKg = "- Preço/Kg: " + getPriceKg() + "\n";
		String grossWeightKg = "- Peso bruto / Kg: " + getGrossWeightKg() + "\n";
		String avgTransformCostKg = "- Custo médio do processo de transformação / Kg: " + getAvgTransformCostKg();
		return "Transformado:\n" + description + origin + weightKg + vatRate + priceKg + grossWeightKg
				+ avgTransformCostKg;
	}
}

public class FoodProduction {
	public static void main(String[] args) {
		Product[] sale = {
				new Fresh("Maçã", "Portugal", 0.25, 0.30, 1.0, 0.50),
				new CannedGood("Salsichas", "Espanha", 1.5, 0.25, 3, 2.0, 2.2, 1.0),
				new Frozen("Douradinhos", "Argentina", 0.75, 0.40, 2.0, 0.85, 3.5),
		};

		double totalCost = 0;
		for (Product product : sale) {
			double finalCost = product.getFinalCost();
			totalCost += finalCost;
			System.out.println(product);
			System.out.println("- Custo final: " + finalCost + "\n");
		}
		System.out.println("Custo total: " + totalCost);
	}
}
