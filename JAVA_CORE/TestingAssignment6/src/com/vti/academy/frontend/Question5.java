package com.vti.academy.frontend;

import java.util.Scanner;

public class Question5 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		
		int age = inputAge();
		System.out.println("tuổi: "+ age);
	}
	public static int inputInt() throws Exception {
		
		try {
			System.out.println("Nhập vào 1 số: ");
			int age = scanner.nextInt();
			return age;
		} catch (Exception e) {
			throw new Exception("Bạn đã không nhập số");
			
		}
		 
	}
	public static int inputAge() throws Exception {
		int tuoi = inputInt();
		while (true) {
			if (tuoi>0) {
				return tuoi;
			}else {
				throw new Exception("Wrong inputing! The age must be greater \r\n"
						+ "than 0, please input again."); 
			}
		}
	}
	
}
