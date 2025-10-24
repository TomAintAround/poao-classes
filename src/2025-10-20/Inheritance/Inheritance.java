class Book {
	private String name;
	private int pages;

	public Book(String name, int pages) {
		this.name = name;
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public int getPages() {
		return pages;
	}

	public void pageMessage() {
		System.out.println("Número de páginas: " + getPages());
	}

	public String toString() {
		return name + " " + pages;
	}
}

class Dictionary extends Book {
	private int entries;

	public Dictionary(String name, int pages, int entries) {
		super(name, pages);
		this.entries = entries;
	}

	public void entriesMessage() {
		System.out.println("Número entradas: " + entries);
		System.out.println("Média por página: " +
				entries / getPages());
	}

	public String toString() {
		return super.toString() + " " + entries;
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Book book = new Book("Carochinha", 30);
		System.out.println("Número de páginas do livro: " + book.getPages());
		book.pageMessage();
		System.out.println(book);

		Dictionary dict = new Dictionary("PT-EN", 500, 5500);
		System.out.println("Número de páginas do dicionário: " + dict.getPages());
		dict.pageMessage();
		dict.entriesMessage();
		System.out.println(dict);

		book = dict;
		System.out.println(book);
	}
}
