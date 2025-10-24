// Folha 4.2.1
// Exercício 4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Bet {
	private int[] nums = new int[4];

	public Bet(int[] nums) {
		assert (nums.length == 4);
		Arrays.sort(nums);
		int i = 0;
		for (int num : nums) {
			assert (num >= 1 && num <= 10);
			this.nums[i++] = num;
		}
	}

	public int[] getNums() {
		return nums;
	}

	public String toString() {
		String result = "[";
		int i = 0;
		for (int num : nums) {
			result += num;
			if (i < 3) {
				result += ", ";
				i++;
			}
		}
		result += "]";
		return result;
	}
}

class Player {
	private String name;
	private int age;
	private int limit;
	private ArrayList<Bet> bets = new ArrayList<>();

	public Player(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void addBets(Bet bet) {
		assert (bets.size() >= limit);
		bets.add(bet);
	}

	public ArrayList<Bet> getBets() {
		return bets;
	}
}

class Client extends Player {
	private int phoneNum;

	public Client(String name, int age, int phoneNum) {
		super(name, age);
		this.phoneNum = phoneNum;
		setLimit(3);
	}

	public String toString() {
		return "(Nome: " + getName() + ", idade: " + getAge() + ", número de telefone: " + phoneNum + ", apostas: "
				+ getBets() + ")";
	}
}

class Employee extends Player {
	private int num;

	public Employee(String name, int age, int num) {
		super(name, age);
		this.num = num;
		setLimit(5);
	}

	public String toString() {
		return "(Nome: " + getName() + ", idade: " + getAge() + ", número interno: " + num + ", apostas: " + getBets()
				+ ")";
	}
}

public class Contest {
	public static void main(String[] args) {
		Client client = new Client("Tomás", 10, 124);
		Employee employee = new Employee("José", 30, 20);
		Bet clientBet1 = new Bet(generateBet());
		Bet clientBet2 = new Bet(generateBet());
		int[] cheatBet = { 1, 4, 6, 7 };
		Bet clientBet3 = new Bet(cheatBet);
		Bet employeeBet1 = new Bet(generateBet());
		Bet employeeBet2 = new Bet(generateBet());
		Bet employeeBet3 = new Bet(generateBet());
		Bet employeeBet4 = new Bet(generateBet());
		Bet employeeBet5 = new Bet(generateBet());
		client.addBets(clientBet1);
		client.addBets(clientBet2);
		client.addBets(clientBet3);
		employee.addBets(employeeBet1);
		employee.addBets(employeeBet2);
		employee.addBets(employeeBet3);
		employee.addBets(employeeBet4);
		employee.addBets(employeeBet5);

		int[] key = { 1, 4, 6, 7 };

		System.out.println(client);
		System.out.println(employee);
		System.out.println("Chave: " + Arrays.toString(key));

		for (Bet bet : client.getBets()) {
			if (Arrays.equals(bet.getNums(), key)) {
				System.out.println(client.getName() + " ganhou!");
				break;
			}
		}
		for (Bet bet : employee.getBets()) {
			if (Arrays.equals(bet.getNums(), key)) {
				System.out.println(employee.getName() + " ganhou!");
				break;
			}
		}
	}

	public static int[] generateBet() {
		Set<Integer> numsSet = new HashSet<>();
		while (numsSet.size() < 4) {
			numsSet.add((int) (Math.random() * 9) + 1);
		}

		int[] nums = new int[4];
		int i = 0;
		for (int num : numsSet) {
			nums[i++] = num;
		}

		return nums;
	}
}
