package com.vti.academy.backend.Static;

import com.vti.academy.entity.Staticvariable.MyMath;
import com.vti.academy.entity.Staticvariable.PrimaryStudent;
import com.vti.academy.entity.Staticvariable.SecondaryStudent;
import com.vti.academy.entity.Staticvariable.Student;

public class Static {
	private Student[] students;
	
	public void question1() {
		students = new Student[3];
	    
		Student student1 = new Student("Nguyen Van A");
		Student student2 = new Student("Nguyen Van B");
		Student student3 = new Student("Nguyen Van C");
		students[0] =student1;
		students[1] =student2;
		students[2] =student3;
		Student.setCollege("Đại hoc bách khoa");
		for (Student student : students) {
			
			System.out.println(student.toString());
		}
	}
	public void question2() {
		Student[] students = new Student[3];
		// In ra số tiền khi: Các Student sẽ nộp quỹ, mỗi Student 100k
		System.out.print("Quỹ lớp sao khi nộp 100 là: ");
		System.out.println(Student.getMoneyGroup());
	
		//  In ra số tiền khi:Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
		students[0].buySomething(50);
		System.out.println("lấy 50,còn lại: ");
		
		System.out.println(Student.getMoneyGroup());
		
		// In ra số tiền khi:Student thứ 2 lấy 20k đi mua bánh mì
		students[1].buySomething(20);
		System.out.print("lấy 20,còn lại: ");
		System.out.println(Student.getMoneyGroup());
		
		// In ra số tiền khi: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
		students[3].buySomething(150);
		System.out.print("lấy 150,còn lại: ");
		System.out.println(Student.getMoneyGroup());
		
	
		// In ra số tiền khi:cả nhóm mỗi người lại đóng quỹ mỗi người 50k
		for (Student student : students) {
			student.fundGroup();
		}
		System.out.println("Số tiền của nhóm là: ");
		System.out.println(Student.getMoneyGroup());
		
	}
	public void question3() {
		int result = MyMath.max(8,9 );
		System.out.println(result);
		result = MyMath.min(19, 9);
		System.out.println(result);
		System.out.println(MyMath.sum(10, 9));
	}
	public void question5() {
		System.out.println("Số sinh viên: ");
		System.out.println(Student.counter);
	}
	public void question6() {
		Student student1 = new PrimaryStudent("Trần Văn A");
		Student student2 = new PrimaryStudent("Trần Văn B");
		Student student3 = new SecondaryStudent("Mai Đình D");
		Student student4 = new SecondaryStudent("Mai Đình C");
		Student student5 = new SecondaryStudent("Hoàng Thị H");
		Student student6 = new SecondaryStudent("Hoàng Thị N");
		
		System.out.println("Số lượng Student: ");
		System.out.println(Student.counter);
		System.out.println("Số lượng PrimaryStudent: "+PrimaryStudent.counterPrimary);
		System.out.println("Số lượng SecondarySudent: " +SecondaryStudent.counterSecondary);
	}
	public void question7() {
		Student student1 = new PrimaryStudent("Trần Văn A");
		Student student2 = new PrimaryStudent("Trần Văn B");
		Student student3 = new PrimaryStudent("Trần Anh T");
		Student student4 = new SecondaryStudent("Mai Đình D");
		Student student5 = new SecondaryStudent("Mai Đình C");
		Student student6 = new SecondaryStudent("Hoàng Thị H");
		Student student7 = new SecondaryStudent("Hoàng Thị N");
		Student student8 = new SecondaryStudent("Đỗ Hông N");
	}
}
