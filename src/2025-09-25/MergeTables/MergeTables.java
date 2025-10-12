// Folha 2
// Exercício 2

public class MergeTables {
	public static int[] fill(int size) {
		int[] table = new int[size];
		for (int i = 0; i < size; i++) {
			table[i] = (int) (Math.random() * 100) + 1;
		}
		return table;
	}

	public static int[] merge(int[] table1, int[] table2) {
		int[] result = new int[table1.length + table2.length];
		int min = Math.min(table1.length, table2.length);
		int i, position = 0;
		for (i = 0; i < min; i++) {
			result[position++] = table1[i];
			result[position++] = table2[i];
		}
		if (table1.length == table2.length) {
			return result;
		}

		// while (i < table1.length) {
		// result[position++] = table1[i++];
		// }
		// while (i < table2.length) {
		// result[position++] = table2[i++];
		// }

		int[] max = table1.length > table2.length ? table1 : table2;
		while (i < max.length) {
			result[position++] = max[i++];
		}
		return result;
	}

	public static void printTable(int[] table) {
		for (int i : table) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int[] table1 = fill(24);
		int[] table2 = fill(4);
		int[] result = merge(table1, table2);

		System.out.print("Table 1: ");
		printTable(table1);
		System.out.print("Table 2: ");
		printTable(table2);
		System.out.print("Result: ");
		printTable(result);
	}
}
