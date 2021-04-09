package com.vti.academy.frontend;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
	public static void main(String[] args) {
		Map<Integer,String> students = new HashMap<>();
		students.put(1, "Nguyễn Văn H");
		students.put(2, "Nguyễn Văn B");
		students.put(3, "Nguyễn Văn C");
		
		System.out.println(students.keySet());//lấy ra id
		System.out.println(students.values());//lấy ra tên 
		
	}
}
