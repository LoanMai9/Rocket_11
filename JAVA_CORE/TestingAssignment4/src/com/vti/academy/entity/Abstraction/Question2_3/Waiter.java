package com.vti.academy.entity.Abstraction.Question2_3;

public class Waiter  extends User{

	public Waiter(String name, double salaryRatio) {
		super(name, salaryRatio);
	}

	@Override
	public double calculatePay() {
		return salaryRatio * 220;
	}

}
