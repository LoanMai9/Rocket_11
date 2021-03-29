package com.vti.academy.entity.Abstraction.Question2_3;

public abstract class User {
	private String name;
	protected double salaryRatio;

	public User(String name, double salaryRatio) {
		super();
		this.name = name;
		this.salaryRatio = salaryRatio;
	}

	public abstract double calculatePay();

	public void displayInfor() {
		System.out.print("Name: \n" + name);
		System.out.print("Salary Ratio: \n" + salaryRatio);
		System.out.print("Pay: \n" + calculatePay());
	}

}
