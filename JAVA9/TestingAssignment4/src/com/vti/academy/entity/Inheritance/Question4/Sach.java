package com.vti.academy.entity.Inheritance.Question4;

import java.util.Scanner;

public class Sach extends TaiLieu {
	private String tenTgia;
	private int noPage;
	private Scanner scanner;
	public Sach() {
		scanner = new Scanner(System.in);
		inputInfor();
	}
	public Sach(int maTailieu, String tenNsx, int sobanPhatHanh) {
		super(maTailieu, tenNsx, sobanPhatHanh);
		this.tenTgia =tenTgia;
		this.noPage= noPage;
	}
	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.println("Mời bạn nhập vào tên tác giả: ");
		tenTgia = scanner.nextLine();
		System.out.println("Mời bạn nhập vào số trang: ");
		noPage = scanner.nextInt();
	}
}
