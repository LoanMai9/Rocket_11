package com.vti.academy.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class CanBo {
	protected String ten;
	protected int tuoi;
	protected boolean gioiTinh;
	protected String diaChi;
	private Scanner scanner;
	
	public CanBo() {
		
	}
	
	public CanBo(String ten, int tuoi, boolean gioiTinh) {
		this.ten =ten;
		this.tuoi =tuoi;
		this.gioiTinh= gioiTinh;
	}
	public void inputInfor() {
		scanner = new Scanner(System.in);
		System.out.print(" mời nhập vào tên: ");
		ten = scanner.nextLine();
		System.out.print("Nhập vào tuổi: ");
		tuoi = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Mời bạn nhập vào giới tính(nam/nu): ");
		String gt = scanner.nextLine();
		gioiTinh = gt.equals("nam") ? true : false ;
	}

	public String getTen() {
		// TODO Auto-generated method stub
		return ten;
	}
}
