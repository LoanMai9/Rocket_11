package com.vti.academy.entity.Abstraction.Question2;


import java.util.Scanner;


public class ThiSinh{
	private String sbd;
	private String hoTen;
	private String diaChi;
	private byte mucUutien;
	private Khoi khoi;
	private Scanner scanner;


	public String getSbd() {
		return sbd;
	}
	public void Nhap() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập vào số báo danh: \n");
		sbd = scanner.nextLine();
		System.out.print("Nhập vào họ và tên: \n");
		scanner.nextLine();
		System.out.print("Nhập vào địa chỉ: \n");
		scanner.nextLine();
		System.out.print("Nhập vào mức ưu tiên: \n");
		scanner.nextByte();
		scanner.nextLine();
		System.out.print("Nhập vào khối: (A/B/C) \n");
		khoi = new Khoi();
		khoi.setTen(scanner.nextLine());
	}
	@Override
	public String toString() {
		return "ThiSinh {sbd=" + sbd + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", mucUutien=" + mucUutien
				+ ", khoi=" + khoi.getTen()+ "}";
	}
	
}
