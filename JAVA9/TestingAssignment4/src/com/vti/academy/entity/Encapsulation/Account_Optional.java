package com.vti.academy.entity.Encapsulation;

public class Account_Optional {
	private int id;
	private String name;
	private int balance;
	
	public Account_Optional(int id, String name, int balance) {
		this.id = id;
		this.name =name;
		this.balance =balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int credit(int amount) {
		return amount;
	}
	public int debit(int amount) {
		return amount;
	}
	public void tranferTo(Account_Optional account, int amount) {
		System.out.println("Tranfer " + account + " to " + account.getName());
	}
}
