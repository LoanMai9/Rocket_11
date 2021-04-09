package com.vti.academy.entity.Staticvariable;

public class PrimaryStudent extends Student {
	public static int counterPrimary = 0 ;
	public PrimaryStudent(String name) {
		super(name);
		this.counterPrimary = counterPrimary++;
	}

}
