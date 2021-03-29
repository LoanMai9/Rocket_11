package com.vti.academy.entity.Inheritance.Question4;

import java.util.Scanner;

public class TapChi extends TaiLieu{
	private  int soPhathanh;
	private int thangPhathanh;
	private Scanner scanner;
	
	public TapChi() {
		scanner = new Scanner(System.in);
		inputInfor();
	}

	public TapChi(int maTailieu, String tenNsx, int sobanPhatHanh) {
		super(maTailieu, tenNsx, sobanPhatHanh);
		this.soPhathanh = soPhathanh;
		this.thangPhathanh = thangPhathanh;
	}

	public void inputInfor() {
		super.inputInfor();
		System.out.println("Mời bạn nhập vào số phát hành: ");
		soPhathanh = scanner.nextInt();
		System.out.println("Mời bạn nhập vào tháng phát hành: ");
		thangPhathanh = scanner.nextInt();
	}
}
