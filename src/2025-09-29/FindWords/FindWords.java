// Folha 2
// Exercício 7

public class FindWords {
	public static int indexOf(char[] line, char[] word, int start) {
		int progress = 0, position = start;
		for (int i = start; i < line.length; i++) {
			if (Character.toLowerCase(line[i]) != Character.toLowerCase(word[progress])) {
				i = ++position - 1; // for loop increments i
				progress = 0;
			} else {
				progress++;
			}

			if (progress == word.length) {
				return position;
			}
		}

		return -1;
	}

	public static char[][] transpose(char[][] table) {
		char[][] result = new char[table[0].length][table.length];

		for (int coluna = 0; coluna < table[0].length; coluna++) {
			for (int linha = 0; linha < table.length; linha++) {
				result[coluna][linha] = table[linha][coluna];
			}
		}

		return result;
	}

	public static void findWord(char[][] table, char[] word) {
		System.out.print("A palavra ");
		for (int i = 0; i < word.length; i++) {
			System.out.printf("%c", word[i]);
		}
		System.out.println(" surge:");
		for (int line = 0; line < table.length; line++) {
			for (int column = 0; column < table[0].length; column++) {
				int position = indexOf(table[line], word, column);
				if (position == -1)
					break;
				column = position;
				System.out.printf("- Ao longo da linha %d com início na coluna %d\n", line + 1, column + 1);
			}
		}

		char[][] transpose = transpose(table);
		for (int line = 0; line < transpose.length; line++) {
			for (int column = 0; column < transpose[0].length; column++) {
				int position = indexOf(transpose[line], word, column);
				if (position == -1)
					break;
				column = position;
				System.out.printf("- Ao longo da coluna %d com início na linha %d\n", line + 1, column + 1);
			}
		}
	}

	public static void main(String[] args) {
		char[][] table = {
				{ 'E', 'b', 'a', 'u', 'l', 'q' },
				{ 'L', 'e', 'r', 'r', 's', 's' },
				{ 'u', 'w', 'u', 'q', 'g', 'r' },
				{ 'a', 'a', 'l', 'l', 'u', 'a' },
				{ 'p', 'm', 'h', 'u', 'd', 'j' }
		};
		char[] word = { 'l', 'u', 'a' };
		findWord(table, word);
	}
}
