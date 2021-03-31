package com.vti.academy.entity.Polymorphism.Question2;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
	private String ten;
	private boolean gtinh;
	private LocalDate birthDate;
	private String diaChi;
	private Scanner scanner;
	
	public Person() {
		
	}

	

	public Person(String ten, boolean gtinh, LocalDate birthDate, String diaChi, Scanner scanner) {
		this.ten = ten;
		this.gtinh = gtinh;
		this.birthDate = birthDate;
		this.diaChi = diaChi;
		this.scanner = scanner;
	}



	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean getGtinh() {
		return gtinh;
	}

	public void setGtinh(boolean gtinh) {
		this.gtinh = gtinh;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public void inputInfor() {
		System.out.println("Nhập tên: ");
		ten = scanner.nextLine();
		System.out.println("Nhập giới tính (nam/nữ): ");
		String gioitinh = scanner.nextLine();
		gtinh = gioitinh.equals("nam") ? true : false;
		System.out.println("Ngập ngày sinh: ");
		birthDate = LocalDate.parse(scanner.nextLine());
		System.out.println("Nhập địa chỉ: ");
		diaChi = scanner.nextLine();
	}
	public void showInfor() {
		System.out.println("Tên: "+ten);
		System.out.println("Giới tính: "+gtinh);
		System.out.println("Ngày sinh: "+birthDate);
		System.out.println("Đại chỉ: "+diaChi);
	}
}
