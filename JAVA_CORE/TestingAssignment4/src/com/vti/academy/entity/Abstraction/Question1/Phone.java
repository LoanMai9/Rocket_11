package com.vti.academy.entity.Abstraction.Question1;

public abstract class Phone {
	private String[] contacts;
	private String number;
	private String name;
	
	public abstract void insertContract(String name, String phone);
	
	public abstract void removeContract(String name);
	
	public abstract void updateContract(String name, String newPhone);
	
	public abstract void searchContact(String name);

	public String[] getContacts() {
		return contacts;
	}

	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
