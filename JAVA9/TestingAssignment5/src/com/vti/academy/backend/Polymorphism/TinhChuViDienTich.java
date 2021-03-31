package com.vti.academy.backend.Polymorphism;

import java.util.Scanner;

import com.vti.academy.entity.Polymorphism.Question3.HinhChuNhat;
import com.vti.academy.entity.Polymorphism.Question3.HinhVuong;

public class TinhChuViDienTich {
	private Scanner scanner;
	public void tinhChuVi() {
		HinhChuNhat hcn = new HinhChuNhat();
		HinhVuong hv = new HinhVuong();
		scanner = new Scanner(System.in);
		System.out.println("Nhập vào a: ");
		float a = scanner.nextFloat();
		System.out.println("Nhập vào b: ");
		float b = scanner.nextFloat();
		System.out.println("Chu vi hình chữ nhật = "+hcn.tinhChuVi(a, b));
		System.out.println("Chu vi hình vuông = "+ hv.tinhChuVi(a));
		
	}
	public void tinhDienTich() {
		HinhChuNhat hcn = new HinhChuNhat();
		HinhVuong hv = new HinhVuong();
		scanner = new Scanner(System.in);
		System.out.println("Nhập vào a: ");
		float a = scanner.nextFloat();
		System.out.println("Nhập vào b: ");
		float b = scanner.nextFloat();
		System.out.println("Diện tích hình chữ nhật= "+hcn.tinhDienTich(a, b));
		System.out.println("Diện tích hình vuông= "+hv.tinhDienTich(a));
	}
}
