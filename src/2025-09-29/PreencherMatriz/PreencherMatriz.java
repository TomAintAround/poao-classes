// Folha 2
// Exercício 5 b, c

public class PreencherMatriz {
	public static int[][] fill(int m, int n, int step) {
		int[][] matrix = new int[m][n];
		int position = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = position;
				position += step;
			}
		}

		return matrix;
	}

	public static int[][] identity(int n) {
		int[][] identity = new int[n][n];
		for (int i = 0; i < n; i++) {
			identity[i][i] = 1;
		}

		return identity;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		int[][] matrix = fill(5, 4, 2);
		int[][] identity = identity(5);
		printMatrix(matrix);
		printMatrix(identity);
	}
}
