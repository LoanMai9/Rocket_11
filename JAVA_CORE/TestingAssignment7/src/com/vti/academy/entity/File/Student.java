package com.vti.academy.entity.File;

import com.vti.academy.Ultis.ScannerUtils;

public class Student {
	private static int counter = 0;

	private int id;
	private String name;

	public Student() {
		this.id = ++counter;
		input();
	}

	public Student(String name) {
		this.name = name;
	}
	private void input() {
		System.out.println("Input name: ");
		name = ScannerUtils.inputName();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
