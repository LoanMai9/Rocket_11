package com.vti.academy.entity.Inheritance.Question4;

import java.util.Scanner;

public class TaiLieu {
	private static int counter = 1000;
	private int maTailieu;
	private String tenNsx;
	private int sobanPhatHanh;
	private Scanner scanner;
	
	public TaiLieu() {
		maTailieu = ++counter;
	}

	public TaiLieu(int maTailieu, String tenNsx, int soPhatHanh) {
		this.maTailieu = maTailieu;
		this.tenNsx = tenNsx;
		this.sobanPhatHanh = soPhatHanh;
	}
	

	public String getTenNsx() {
		return tenNsx;
	}

	public int getSobanPhatHanh() {
		return sobanPhatHanh;
	}

	
	public void inputInfor() {
		scanner = new Scanner(System.in);
		System.out.print(" Mời nhập vào mã tài liệu: "+ maTailieu);
		scanner.nextLine();
		System.out.print("Mời nhập vào tên nhà sản xuất:");
		tenNsx = scanner.nextLine();
		System.out.print("Mời nhập vào số bản phát hành: ");
		sobanPhatHanh = scanner.nextInt();
		
	}

	public int getMaTailieu() {
		return maTailieu;
	}
}
