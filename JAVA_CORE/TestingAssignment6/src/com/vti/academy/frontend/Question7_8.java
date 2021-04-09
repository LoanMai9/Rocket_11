package com.vti.academy.frontend;

import com.vti.academy.entity.ScannerUtils;

public class Question7_8 {
	public static void main(String[] args) {
		System.out.println("Nhập id: ");
		int id = ScannerUtils.inputInt("Id phải là 1 số, mời nhập lại: ");

		System.out.println("Id của bạn: " + id);

		System.out.println("Nhập điểm trung bình: ");
		float dtb = ScannerUtils.inputFloat("Điểm trung bình phải là 1 số thực, mời nhập lại: ");

		System.out.println("Điểm trung bình của bạn: " + dtb);

		System.out.println("Nhập tên của học sinh: ");
		String name = ScannerUtils.inputString("Tên phải là 1 String khác rỗng, mời nhập lại: ");

		System.out.println("Tên của bạn: " + name);
	}
}
