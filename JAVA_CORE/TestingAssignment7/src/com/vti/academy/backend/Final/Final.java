package com.vti.academy.backend.Final;

import com.vti.academy.entity.Final.MyMath;
import com.vti.academy.entity.Final.PrimaryStudent;
import com.vti.academy.entity.Final.SecondaryStudent;
import com.vti.academy.entity.Final.Student;

public class Final {
	public void question1() {
		System.out.println(MyMath.sum(6));
	}
	public void question2() {
		Student student1 = new Student(1, "Trang");
		System.out.println(student1);
		Student student2 = new Student(2, "Linh");
		System.out.println(student2);
	}
	public void question3() {
		PrimaryStudent.study();
		SecondaryStudent.study();
	}
}
