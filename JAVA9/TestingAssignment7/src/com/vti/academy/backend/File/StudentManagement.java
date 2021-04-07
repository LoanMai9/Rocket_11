package com.vti.academy.backend.File;

import java.util.ArrayList;
import java.util.List;

import com.vti.academy.entity.File.Student;

public class StudentManagement {
	private List<Student> students ;
	private  String pathFile;
	
	public StudentManagement() {
		students = new ArrayList<Student>();
		pathFile ="C:\\Users\\pc\\Desktop\\Test.txt";
	}
}
