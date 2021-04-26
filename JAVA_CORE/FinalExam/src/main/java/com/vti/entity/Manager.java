package com.vti.entity;

public class Manager extends User{
	private int expInYear;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	
	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("So nam kinh nghiem: " + expInYear);
	}
	
}
