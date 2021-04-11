package com.vti.academy.frontend;

import java.util.Date;

import com.vti.academy.entity.Student;

public class AnnotationsProgram {
	public static void main(String[] args) {
		//question1();
		question2();
	}
	@SuppressWarnings("deprecation")
	public static void question1() {
		Date date = new Date("2020/05/18");
		System.out.println(date);
	}
	
	private static void question2() {
		Student student = new Student();
		student.setName("Nguyễn Văn A");
		System.out.println(student.getName());
		System.out.println(student.getId());
		System.out.println(student.getIdV2());
		
	}
}
