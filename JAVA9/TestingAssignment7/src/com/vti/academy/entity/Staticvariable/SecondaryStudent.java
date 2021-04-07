package com.vti.academy.entity.Staticvariable;

public class SecondaryStudent extends Student{
	public static int counterSecondary=0;
	public SecondaryStudent(String name) {
		super(name);
		this.counterSecondary = counterSecondary++;
	}

}
