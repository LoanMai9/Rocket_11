package com.vti.academy.Utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputAge() {
		while (true) {
			int age = inputInt("Wrong inputing! Please input an age as int, input again.");
			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");
			} else {
				return age;
			}
		}
	}

	public static int inputAgeGreaterThan18() {
		while (true) {
			int age = inputAge();
			if (age >= 18) {
				return age;
			} else {
				System.err.println("Wrong inputing! The age must be greater than 18, please input again.");
			}
		}
	}
	
	public static String inputEmail() {
		while(true) {
			String email = inputString("Wrong inputing! The email is not empty");
			if(email.contains("@")) {
				return email;
			} else {
				System.err.println("email has @.");
			}
		}
	}
	public static String inputName() {
		while(true) {
			String name = inputString("Wrong inputing! The name is not empty");
			String[] partname = name.split("\\s+");
			String nameout = "";
			for (int i = 0; i < partname.length; i++) {
				String s3 = partname[i].substring(0, 1).toUpperCase();
				nameout =nameout + s3 + partname[i].substring(1) + " ";
			}
			return nameout;
		}
	}
}
