package com.vti.academy.entity.Inheritance.Question1_2;

import java.util.Scanner;

//quan hệ kế thừa là có cùng bản chất và giống nhau nhiều về các đặc điểm
public class NhanVien extends CanBo {
	
	private String congViec;
	
	private Scanner scanner;
	
	public NhanVien() {
		scanner = new Scanner(System.in);
		inputInfor();
	}
	
	public NhanVien(String ten, int tuoi, boolean gioiTinh) {
		super(ten, tuoi, gioiTinh);
		this.congViec =congViec;
	}
	
	
	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.println("Nhập vào cong viec: ");
		congViec =scanner.nextLine();
	}
	
}
