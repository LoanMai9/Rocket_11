package com.vti.academy.entity.Inheritance.Question4;

import java.util.Scanner;

public class Bao extends TaiLieu {
	private int ngayPhathanh;
	private Scanner scanner;

	public Bao() {
		scanner = new Scanner(System.in);
		inputInfor();
	}

	public Bao(int maTailieu, String tenNsx, int sobanPhatHanh) {
		super(maTailieu, tenNsx, sobanPhatHanh);
		this.ngayPhathanh = ngayPhathanh;
	}

	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.println("Mời bạn nhập vào ngày phát hành: ");
		ngayPhathanh = scanner.nextInt();
	}
}
