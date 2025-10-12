// Folha 2
// Exercício 6

import java.util.Arrays;

public class Sudoku {
	public static int[] possibleResults(int[][] table, int x, int y) {
		x--;
		y--;
		boolean[] valid = new boolean[table.length + 1];
		Arrays.fill(valid, true);
		valid[0] = false;

		for (int i = 0; i < table[0].length; i++) {
			valid[table[x][i]] = false;
		}
		for (int i = 0; i < table.length; i++) {
			valid[table[i][y]] = false;
		}
		int vectorSize = 0;
		for (int i = 1; i < valid.length; i++) {
			if (valid[i]) {
				vectorSize++;
			}
		}
		int[] result = new int[vectorSize];
		int position = 0;
		for (int i = 1; i < valid.length; i++) {
			if (valid[i]) {
				result[position++] = i;
			}
		}

		return result;
	}

	public static void printVector(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%1d ", vector[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] sudoku = {
				{ 4, 0, 1, 0 },
				{ 1, 2, 0, 4 },
				{ 2, 0, 3, 1 },
				{ 0, 1, 0, 0 }
		};
		int[] possibleValues = possibleResults(sudoku, 4, 3);
		printVector(possibleValues);
	}
}
