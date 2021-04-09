package com.vti.academy.entity.Polymorphism.Question2;

import java.util.Scanner;

public class Student extends Person{
	private int masv;
	private float dtb;
	private String email;
	private Scanner scanner;
	
	public Student() {
		scanner = new Scanner(System.in);
		inputInfor();
	}


	public Student(int masv, float dtb, String email) {
		super();
		this.masv = masv;
		this.dtb = dtb;
		this.email = email;
	}
	

	public int getMasv() {
		return masv;
	}

	public float getDtb() {
		return dtb;
	}


	public void setDtb(float dtb) {
		this.dtb = dtb;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override 
	public void inputInfor() {
		super.inputInfor();
		System.out.println("Nhập mã sinh viên: ");
		masv = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Nhập vào điểm trung bình: ");
		dtb= scanner.nextFloat();
		scanner.nextLine();
		System.out.println(" Nhập vào email: ");
		email = scanner.nextLine();
		
	}
	@Override
	public void showInfor() {
		super.inputInfor();
		System.out.println("Mã ssinh viên: "+masv);
		System.out.println("điểm trung bình: "+dtb);
		System.out.println("Email: "+email);
	}
	public boolean isStudentgetAward() {
		return dtb >=8.0;
	}
}
