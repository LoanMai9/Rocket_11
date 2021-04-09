package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.Inheritance.Question4.Bao;
import com.vti.academy.entity.Inheritance.Question4.Sach;
import com.vti.academy.entity.Inheritance.Question4.TaiLieu;
import com.vti.academy.entity.Inheritance.Question4.TapChi;

	//Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi 
	//tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất), 
	//Tên nhà xuất bản, số bản phát hành.
	//Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
	//Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
	//Các báo cần quản lý thêm: Ngày phát hành.
	//Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một 
	//cách hiệu quả.
	//Xây dựng lớp QuanLySach có các chức năng sau
	//a) Thêm mới tài liêu: Sách, tạp chí, báo.4
	//b) Xoá tài liệu theo mã tài liệu.
	//c) Hiện thị thông tin về tài liệu.
	//d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
	//e) Thoát khỏi chương trình.

public class QLTV {
	private List<TaiLieu>  tailieus ;
	private Scanner scanner;
	
	public QLTV() {
		tailieus = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	// thêm mới tài liệu
	public void addTaiLieu() {
		System.out.print("Bạn muốn thêm mới tài liệu nào (1.Sách 2.Tạp chí 3.Báo): ");
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch(choose) {
		case 1:
			Sach s = new Sach();
			tailieus.add(s);
			System.out.println("Thêm thành công!");
			break;
		case 2:
			TapChi tt = new TapChi();
			tailieus.add(tt);
			System.out.println("Thêm thành công!");
			break;
		case 3:
			Bao b = new Bao();
			tailieus.add(b);
			System.out.println("Thêm thành công!");
			break;
		default:
			System.out.println("Nhập sai. Mời nhập lại!");
			break;
		}
	}
	// xóa tài liệu
	public void deleteTaiLieu() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập vào mã tài liệu cần xóa: ");
		int maTailieu = scanner.nextInt();
		for (TaiLieu taiLieu : tailieus) {
			if(maTailieu == taiLieu.getMaTailieu()) {
				tailieus.remove(maTailieu);
			}
		}
	}
	// tìm tài liệu
	public void findTaiLieu() {
		scanner = new Scanner(System.in);
		System.out.print("Tìm kiếm tài liệu theo loại(1.Sách 2.Tạp chí 3.Báo): ");
		int choose = scanner.nextInt();
		switch (choose) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		default:
			break;
		}
		
	}
	// In thông tin
	public void printTaiLieu() {
		System.out.print("Hiển thị thông tin về tài liệu: ");
		for (TaiLieu taiLieu : tailieus) {
			taiLieu.inputInfor();
		}
	}
	
}
