package com.vti.academy.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class KySu extends CanBo{
	private String nganhDaotao;
	private Scanner scanner;
	
	public KySu() {
		scanner = new Scanner(System.in);
		inputInfor();
	}
	public KySu(String ten, int tuoi, boolean gioiTinh) {
		super(ten, tuoi, gioiTinh);
		this.nganhDaotao = nganhDaotao;
	}
	
	@Override
	public void inputInfor() {
		super.inputInfor();
		System.out.print("Nhập vào ngành đào tạo: ");
		nganhDaotao = scanner.nextLine();
	}
	
}
