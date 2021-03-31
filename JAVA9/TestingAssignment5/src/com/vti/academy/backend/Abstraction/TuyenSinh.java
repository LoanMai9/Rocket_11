package com.vti.academy.backend.Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.Abstraction.Question2.ITuyenSinh;
import com.vti.academy.entity.Abstraction.Question2.ThiSinh;



public class TuyenSinh implements ITuyenSinh {
	private List<ThiSinh> thisinhs = new ArrayList<>();
	private Scanner scanner;
	
	public TuyenSinh() {
		scanner = new Scanner(System.in);
	}
	@Override
	public void addThisinh() {
		scanner = new Scanner(System.in);
		System.out.println("Thêm số thí sinh muốn nhập: ");
		int n = scanner.nextInt();
		for(int i= 0; i<n;i++) {
			ThiSinh thisinh = new ThiSinh();
			thisinh.Nhap();
			thisinhs.add(thisinh);
		}
		
	}
	@Override
	public void displayThisinh() {
		for (ThiSinh thiSinh : thisinhs) {
			System.out.println(thisinhs);
		}
	}
	@Override
	public void searchThisinh() {
		System.out.println("Nhập số báo danh cần tìm: ");
		String sbd = scanner.nextLine();
		for (ThiSinh thiSinh : thisinhs) {
			if(thiSinh.getSbd().equals(sbd)) {
				System.out.println(thiSinh);
			}
		}
	}
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}
	
}
