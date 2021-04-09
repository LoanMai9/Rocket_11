package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.academy.Utils.ScannerUtils;
import com.vti.academy.entity.Collection.Student;

public class Listt {
	private List<Student> students;

	public Listt() {
		students = new ArrayList<>();
		Ques1();
	}

	public void Ques1() {
		students.add(new Student("Nguyen Van A"));
		students.add(new Student("Nguyen Van B"));
		students.add(new Student("Nguyen Van C"));
		students.add(new Student("Nguyen Van A"));
		students.add(new Student("Nguyen Van E"));
		students.add(new Student("Nguyen Van B"));
		students.add(new Student("Nguyen Van G"));
	}
	
	public void addInto(int a, String name) {
		students.add(a,new Student(name));
	}

	public void amount() {
		System.out.println("So phan tu:" + (students.size()));
	}

	public void getIndex(int a) {
		System.out.println("Phan tu thu " + (a + 1) + ":" + students.get(a));
	}

	public void firstAndLast() {
		System.out.println("Phan tu dau:" + students.get(0));
		System.out.println("Phan tu cuoi:" + students.get(students.size() - 1));
	}
	
	public void print() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void reverse() {
		print();
		Collections.reverse(students);
		System.out.println("Sau khi doi nguoc:");
		print();
	}
	
	public void findById() {
		System.out.print("id can tim:");
		int n = ScannerUtils.inputInt("xin nhap vao dung id.");
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == n) {
				System.out.println(students.get(i));
			} else {
				System.out.println("khong co thong tin can tim.");
			}
		}
	}

	public void findByName() {
		System.out.print("name can tim:");
		String name = ScannerUtils.inputName();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				System.out.println(students.get(i));
			} else {
				System.out.println("khong co thong tin can tim.");
			}
		}
	}

	public void findDuplicateStudent() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i).getName().equals(students.get(j).getName())) {
					System.out.println("Các student trùng tên: ");
					System.out.println(students.get(i));
					System.out.println(students.get(j));
				}
			}
		}
	}

	public void deleteById(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.get(i).setName(null);
			}
		}
	}

	public void deleteStudentById(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
			}
		}
	}
	
	public void addToStudentCopies() {
		ArrayList<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(students);
		for (Student student : studentCopies) {
			System.out.println(student);
		}
	}
}
