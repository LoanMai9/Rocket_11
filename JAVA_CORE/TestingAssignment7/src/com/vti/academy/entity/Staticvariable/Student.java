package com.vti.academy.entity.Staticvariable;

public class Student {
	
	private int id;
	private String name;
	public  static String college ="Đại học Bách Khoa";
	private static int moneyGroup=0;
	public static int counter= 0;
	public static final int maxStudent =7;
	
	public Student(String name) {
		this.name = name;
		this.moneyGroup +=100;
		this.id = counter++;
		if (counter > maxStudent) {
			System.err.println("Sinh viên tối đa là 7.");
		}
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Student.counter = counter;
	}


	public static double getMoneyGroup() {
		return moneyGroup;
	}
	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}
	
	
	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}
	
	public void buySomething(int money) {
		this.moneyGroup = moneyGroup - money;
	}
	public void fundGroup() {
		this.moneyGroup = moneyGroup +50;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" +college + "]";
	}
	
}
