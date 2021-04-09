package com.vti.academy.frontend;

import com.vti.academy.backend.Listt;

public class ListProgram {
//	a) In ra tổng số phần tử của students
//	b) Lấy phần tử thứ 4 của students
//	c) In ra phần tử đầu và phần tử cuối của students
//	d) Thêm 1 phần tử vào vị trí đầu của students
//	e) Thêm 1 phần tử vào vị trí cuối của students
//	f) Đảo ngược vị trí của students
//	g) Tạo 1 method tìm kiếm student theo id
//	h) Tạo 1 method tìm kiếm student theo name
//	i) Tạo 1 method để in ra các student có trùng tên
//	j) Xóa name của student có id = 2;
//	k) Delete student có id = 5;
//	l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
//	studentCopies
	public static void main(String[] args) {
		Listt listt = new Listt();
		listt.amount();
		listt.getIndex(4);
		listt.firstAndLast();
		listt.print();
		listt.reverse();
		listt.findById();
		listt.findByName();
		listt.findDuplicateStudent();
		listt.deleteById(2);
		listt.deleteStudentById(5);
		listt.addToStudentCopies();
		
	}
}
