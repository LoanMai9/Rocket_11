package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.Abstraction.TuyenSinh;


public class Que2AbstractProgram {
	 public static void main(String[] args) {
		TuyenSinh tuyenSinh = new TuyenSinh();
		System.out.println(" Mời bạn nhập các chức năng\n"
										+ " 1. Thêm mới thí sinh \n"+
											"2.Hiển thị thí sinh và khối\n"+
											"3.Tìm kiếm theo số báo danh\n"+
											"4.Thoát\n");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("Mời bạn nhập chức năng: ");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Thêm mới thí sinh: ");
				tuyenSinh.addThisinh();
				break;
			case 2:
				System.out.println("Hiển thị thí sinh và khối: ");
				tuyenSinh.displayThisinh();
				break;
			case 3:
				System.out.println("Tìm kiếm theo số báo danh: ");
				tuyenSinh.searchThisinh();
				break;
			case 4:
				System.out.println("Thoát chương trình");
				scanner.close();
				return;
			default:
				System.out.println("Nhập sai.Mời nhập lại!");
				break;
			}
			
		}
	}
}
