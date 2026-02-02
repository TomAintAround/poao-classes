import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

class Record implements Serializable {
	private int day;
	private int minTemp;
	private int maxTemp;

	public Record(int day, int minTemp, int maxTemp) {
		this.day = day;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public int getAmplitude() {
		return maxTemp - minTemp;
	}

	public int getDay() {
		return day;
	}

	public String toString() {
		return "Dia: " + day + ", temperatura mínima: " + minTemp + ", temperatura máxima: " + maxTemp;
	}
}

public class Temperatures {
	public static void main(String[] args) {
		LinkedList<Record> temperatures = new LinkedList<>();

		File inputFile = new File("temperatures.txt");
		if (inputFile.exists() && inputFile.isFile()) {
			try {
				FileReader fileReader = new FileReader(inputFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					String[] lineSplit = line.split(" ");
					int day = Integer.parseInt(lineSplit[0]);
					int minTemp = Integer.parseInt(lineSplit[1]);
					int maxTemp = Integer.parseInt(lineSplit[2]);
					temperatures.add(new Record(day, minTemp, maxTemp));
				}
				bufferedReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erro ao abrir o ficheiro de texto");
			} catch (IOException e) {
				System.out.println("Erro ao ler ficheiro de texto");
			}
		} else {
			System.out.println("O ficheiro de texto não existe.");
		}

		File outputFile = new File("result.obj");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(temperatures);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao criar ficheiro binário");
		} catch (IOException e) {
			System.out.println("Erro a escrever para o ficheiro binário");
		}

		File inputObject = new File("result.obj");
		try {
			FileInputStream fileInputStream = new FileInputStream(inputObject);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			@SuppressWarnings("unchecked")
			LinkedList<Record> readTemperatures = (LinkedList<Record>) objectInputStream.readObject();
			for (Record record : readTemperatures) {
				System.out.println(record);
			}
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro a abrir o ficheiro binário");
		} catch (IOException e) {
			System.out.println("Erro a ler o ficheiro binário");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro a converter objeto lido no ficheiro binário");
		}
	}
}
