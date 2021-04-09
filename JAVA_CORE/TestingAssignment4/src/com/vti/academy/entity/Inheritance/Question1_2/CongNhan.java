package com.vti.academy.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class CongNhan extends CanBo {

	private int bac;
	private Scanner scanner;
	
	public CongNhan() {
		scanner = new Scanner(System.in);
		inputInfor();
	}
	
	public CongNhan(String ten, int tuoi, boolean gioiTinh) {
		super(ten, tuoi, gioiTinh);
		this.bac =bac;
	}
	
	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.print("Mời bạn nhập cấp bậc: ");
		bac = scanner.nextInt();
	}
}
