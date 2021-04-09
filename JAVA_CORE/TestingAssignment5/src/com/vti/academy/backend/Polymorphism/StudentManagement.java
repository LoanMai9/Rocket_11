package com.vti.academy.backend.Polymorphism;

import com.vti.academy.entity.Polymorphism.Question1.Student;

public class StudentManagement {
	private Student[] students;

	public StudentManagement() {
		students = new Student[10];
	}

	// a) Tạo 10 học sinh, chia thành 3 nhóm
	public void initStudent() {
		students[1] = new Student(1, "Nguyễn Văn A", 1);
		students[2] = new Student(2, "Nguyễn Văn B", 2);
		students[3] = new Student(3, "Nguyễn Văn C", 3);
		students[4] = new Student(4, "Nguyễn Văn D", 1);
		students[5] = new Student(5, "Nguyễn Văn F", 3);
		students[6] = new Student(6, "Nguyễn Văn G", 2);
		students[7] = new Student(7, "Nguyễn Văn H", 2);
		students[8] = new Student(8, "Nguyễn Văn I", 3);
		students[9] = new Student(9, "Nguyễn Văn K", 1);
		students[10] = new Student(10, "Nguyễn Văn M", 1);
	}

	// Kêu gọi cả lớp điểm danh.
	public void calopdiemDanh() {
		for(int i= 0; i<11; i++) {
			students[i].diemDanh();
		}
	}
//	Gọi nhóm 1 đi học bài
	public void nhomHocBai() {
		for(int i=0; i<11; i++) {
			if(students[i].getGroup()==1) {
				students[i].hocBai();
			}
		}
	}
	
	
//	Gọi nhóm 2 đi dọn vệ sinh
	public void nhomDonVesinh() {
		for(int i=0; i<11;i++) {
			if(students[i].getGroup() == 2) {
				students[i].donVesinh();
			}
		}
	}
}
