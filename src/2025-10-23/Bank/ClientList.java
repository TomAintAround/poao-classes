// Folha 4.2.1
// Exercício 3

import java.util.ArrayList;

class Account {
	private String name;
	private int num;
	private AccountType type;
	private double balance;
	private ArrayList<Double> movements = new ArrayList<>();

	public enum AccountType {
		Ordem, Prazo
	}

	public Account(String name, int num, AccountType type, int balance) {
		this.name = name;
		this.num = num;
		this.type = type;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "(Nome: " + name + ", número: " + num + ", tipo: " + type + ", saldo: " + balance + ", movimentos: "
				+ movements + ")";
	}
}

class Bank {
	private ArrayList<Account> clientList = new ArrayList<>();

	public void addAccount(Account account) {
		clientList.add(account);
	}

	public ArrayList<Account> getAccountsWithMoreThan(double ammount) {
		ArrayList<Account> newClientList = new ArrayList<>();
		for (Account account : clientList) {
			if (account.getBalance() > ammount)
				newClientList.add(account);
		}
		return newClientList;
	}
}

public class ClientList {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Account client1 = new Account("Tomás", 5, Account.AccountType.Ordem, 100);
		Account client2 = new Account("José", 10, Account.AccountType.Ordem, 10_000);
		Account client3 = new Account("João", 2, Account.AccountType.Prazo, 1_000);
		Account client4 = new Account("Cristiano", 7, Account.AccountType.Ordem, 5);
		Account client5 = new Account("Alexandre", 1, Account.AccountType.Prazo, 100);
		bank.addAccount(client1);
		bank.addAccount(client2);
		bank.addAccount(client3);
		bank.addAccount(client4);
		bank.addAccount(client5);
		System.out.println(bank.getAccountsWithMoreThan(100));
	}
}
