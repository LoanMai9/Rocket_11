package com.vti.academy.backend.Polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.Polymorphism.Question2.Student;

public class PersonManagement {
	private List<Student> students;
	private Scanner scanner;
	public PersonManagement() {
		students = new ArrayList<>();
		scanner = new Scanner(System.in);
		
	}
	public void nhap() {
		System.out.println("Nhập vào số sinh viên : ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Sinh viên thứ: "+i);
			students.add(new Student());
		}
	}
	
	public void xuat() {
		for (Student student : students) {
			student.showInfor();
		}
	}
	public void xetHocBong() {
		System.out.println("Nhập tên sinh viên muốn xét: ");
		String ten = scanner.nextLine();
		for (Student student : students) {
			if(student.getTen().equals(ten)){
				if(student.isStudentgetAward()) {
					System.out.println("Sinh viên "+ten+"Được học bổng");
				}else {
					System.out.println("Sinh viên "+ten+"không được học bổng");
				}
				return;
			}
		}
	}
}
