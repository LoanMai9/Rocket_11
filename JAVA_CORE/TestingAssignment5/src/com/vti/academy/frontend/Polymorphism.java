package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.Polymorphism.PersonManagement;
import com.vti.academy.backend.Polymorphism.StudentManagement;
import com.vti.academy.backend.Polymorphism.TinhChuViDienTich;

public class Polymorphism {
	public static void main(String[] args) {
		//question1();
		//question2();
		question3();
	}
	public static void question1() {
		StudentManagement stuma = new StudentManagement();
		stuma.calopdiemDanh();
		stuma.nhomHocBai();
		stuma.nhomDonVesinh();
	}
	public static void question2() {
		PersonManagement pm = new PersonManagement();
		pm.nhap();
		pm.xuat();
		pm.xetHocBong();
	}
	public static void question3() {
		TinhChuViDienTich tinh = new TinhChuViDienTich();
		tinh.tinhChuVi();
		tinh.tinhDienTich();
	}
}
