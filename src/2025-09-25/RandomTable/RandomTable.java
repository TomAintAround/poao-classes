// Folha 2
// Exercício 1

public class RandomTable {
	public static int[] fill(int size) {
		int table[] = new int[size];
		for (int i = 0; i < size; i++) {
			table[i] = (int) (Math.random() * 100) + 1;
		}
		return table;
	}

	public static void print(int[] table) {
		System.out.print("Table: ");
		for (int i : table) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int size = 10;
		int[] table = fill(size);
		print(table);
	}
}
