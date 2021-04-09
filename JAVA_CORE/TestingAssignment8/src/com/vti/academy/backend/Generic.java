package com.vti.academy.backend;

import com.vti.academy.entity.Generic.Employee;
import com.vti.academy.entity.Generic.Phone;
import com.vti.academy.entity.Generic.Staff;
import com.vti.academy.entity.Generic.Student;

public class Generic {
	public void question12() {
		Student<Integer> studentInt = new Student<>(1, "Nguyễn Văn A");
		Student<Float> studentFloat = new Student<>(2.0f, "Nguyễn Văn B");
		Student<Double> studentDouble = new Student<>(3.0, "Nguyễn Văn C");
		print(studentInt);
		print(studentFloat);
		print(studentDouble);
		print(4);
		print(4.0);
	}

//	Tạo method để in ra thông tin nhập vào (parameter)
//	(parameter có thể là họ và tên, hoặc student, hoặc int)
	public <T> void print(T a) {
		System.out.println(a);
	}

	public <T> void print(T[] a) {
		for (T t : a) {
			System.out.println(t);
		}
	}
//	Tạo 1 array int, 1 array float, 1 array long, 1 array double
//	Tạo 1 method có parameter là array và in ra các số trong array đó

	public void question4() {
		Integer[] arrInt = { 1, 2, 3, 4, 5 };
		Float[] arrFloats = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f };
		Double[] arrDoubles = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		print(arrInt);
		print(arrFloats);
		print(arrDoubles);

	}

	public void question5() {

		// khởi tạo employee có salaries datatype là int
		Integer[] salaryEmployee1 = { 1000, 2000, 3000 };
		Employee<Integer> employee1 = new Employee<Integer>(1, "Hải", salaryEmployee1);

		System.out.println("Employee vừa khởi tạo: ");
		System.out.println(employee1);
		System.out.println("Tháng lương cuối cùng của employee 1: " + salaryEmployee1[salaryEmployee1.length - 1]);

		// khởi tạo employee có salaries datatype là Float
		Float[] salaryEmployee2 = { 1000f, 2000f, 3000f, 4000f };
		Employee<Float> employee2 = new Employee<Float>(1, "Trung", salaryEmployee2);

		System.out.println("Employee vừa khởi tạo: ");
		System.out.println(employee2);
		System.out.println("Tháng lương cuối cùng của employee 2: " + salaryEmployee2[salaryEmployee2.length - 1]);

		// khởi tạo employee có salaries datatype là double
		Double[] salaryEmployee3 = { 1000d, 2000d, 3000d, 4000d, 5000d, 6000d };
		Employee<Double> employee3 = new Employee<Double>(1, "Tuấn", salaryEmployee3);

		System.out.println("Employee vừa khởi tạo: ");
		System.out.println(employee3);
		System.out.println("Tháng lương cuối cùng của employee1: " + salaryEmployee3[salaryEmployee3.length - 1]);
	}

	public void question6() {
//		tạo 1 object Student có key là Mã sinh viên 
//		và value là tên của sinh viên đó
		Student<Integer> student1 = new Student<>(999, "Loan Mai");
		System.out.println("Id: " + student1.getId() + " | " + "Name: " + student1.getName());
	}

	public void question7() {
		// <email, phone number>
		Phone<String, String> email = new Phone<String, String>("dnt@gmail.com", "0338871367");
		System.out.println("Email: " + email.getKey() + " | " + "Phone Number: " + email.getPhoneNumber());

		// <id, phone number>
		Phone<Integer, String> id = new Phone<Integer, String>(1, "0338871367");
		System.out.println("Id: " + id.getKey() + " | " + "Phone Number: " + id.getPhoneNumber());

		// <name, phone number>
		Phone<String, String> name = new Phone<String, String>("Anh", "0338871367");
		System.out.println("Name: " + name.getKey() + " | " + "Phone Number: " + name.getPhoneNumber());
	}

	public void question8() {
		// int
		Staff<Integer> intStaff = new Staff<>(1, "Nguyễn Trung Quân");
		System.out.println("Id: " + intStaff.getId() + " | " + "Name: " + intStaff.getName());

		// float
		Staff<Float> floatStaff = new Staff<>(1.5f, "Nguyễn Trung Anh");
		System.out.println("Id: " + floatStaff.getId() + " | " + "Name: " + floatStaff.getName());
	}
}
