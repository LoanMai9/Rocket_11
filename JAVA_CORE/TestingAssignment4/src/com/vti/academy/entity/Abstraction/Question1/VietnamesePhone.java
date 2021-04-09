package com.vti.academy.entity.Abstraction.Question1;

public class VietnamesePhone extends Phone {
	public VietnamesePhone() {

	}

	@Override
	public void insertContract(String name, String phone) {
		System.out.println("Insert new contact with name " + name + "and phone: " + phone);
	}

	@Override
	public void removeContract(String name) {
		System.out.println("Removing contact with name " + name);
	}

	@Override
	public void updateContract(String name, String newPhone) {
		System.out.println("Update contact with name " + name + " and new phone " + newPhone);
	}

	@Override
	public void searchContact(String name) {
		System.out.println("Search contact with name " + name);
	}

}
