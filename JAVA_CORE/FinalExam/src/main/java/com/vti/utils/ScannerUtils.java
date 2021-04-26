package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static String inputEmail(String errorMessage) {
		while (true) {
			String email = ScannerUtils.inputString(errorMessage);
			if (email == null || !email.contains("@gmail.com")) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại email: ");
			} else {
				return email;
			}
		}
	}


	public static String inputPassword(String errorMessage) {
		while (true) {
			String password = ScannerUtils.inputString(errorMessage);
			if (password.length() < 6 || password.length() > 12) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
				continue;
			}

			boolean hasAtLeast1Character = false;

			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
			}
		}
	}
	public static boolean checkUpperCase(String string)
	{
		for (int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(string.charAt(i)) == true) {
				return true;
			}
		}
		return false;
	}
	// chi nhap duoc Manager or Employee
		public static String inputRole()
		{
			while(true)
			{
				String role = inputString("Role khong duoc de trong, moi nhap lai!");
				if (role.equalsIgnoreCase("Manager") || role.equalsIgnoreCase("Employee")) {
					return role;
				}
				else {
					System.err.println("Role phai la MANAGER or EMPOYEE, moi ban nhap lai!");
				}
			}
		}
		public static String inputFullName() {
			while (true) {
				String fullName = inputString("Ten khong duoc de trong, moi ban nhap lai!!!");
				fullName.trim();
				fullName.replaceAll("\\s+", " ");
				String[] name = fullName.split(" ");
				int count = 0;
				String result = "";
				for (int i = 0; i < name.length; i++) {
					count++;
					result += String.valueOf(name[i].charAt(0)).toUpperCase() + name[i].substring(1) + " ";
				}
				if (count >= 2) {
					return result;
				} else {
					System.out.println("Ten cua ban phai co nhieu hon hai ki tu, moi nhap lai!!");
				}
			}

		}

	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = ScannerUtils.inputString(errorMessage);
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Mời bạn nhập lại phone number: ");
			}

		}
	}

	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int id = ScannerUtils.inputInt(errorMessage);
			if (id < 0) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = scanner.nextLine();
				input = input.trim();
				int output = Integer.parseInt(input);
				return output;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	public static int inputId()
	{
		while(true)
		{
			int input = inputInt("Ban phai nhap so, moi nhap lai!");
			if (input > 0) {
				return input;
			}
			else {
				System.err.println("So phai lon hon 0, moi ban nhap lai!");
			}
		}
	}
	public static float inputFloat(String errMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errMessage);
			}
		}
	}

	public static long inputLong(String errMessage) {
		while (true) {
			try {
				return Long.parseLong(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errMessage);
			}
		}
	}

	public static double inputDouble(String errMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errMessage);
			}
		}
	}

	

	// NHẬP VÀO TIỀN
	public static float inputPositiveMoney(String erroMessage2) {
		while (true) {
			float money = ScannerUtils.inputMoney(erroMessage2);
			if (money < 0) {
				System.err.print(erroMessage2);
			} else {
				return money;
			}
		}
	}

	public static float inputMoney(String errorMessage) {
		while (true) {
			try {
				String inputMoney = scanner.nextLine();
				inputMoney = inputMoney.trim();
				float outputMoney = Float.parseFloat(inputMoney);
				return outputMoney;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {

			String inputString = scanner.nextLine();
			inputString = inputString.trim();
			inputString = inputString.replaceAll("\\s+", " ");

			return inputString;
		}
	}

	// NHẬP VÀO TÊN VÀ CHUẨN HÓA TÊN:
	public static String inputName(String errorMessage) {
		while (true) {

			String name = ScannerUtils.inputString(errorMessage);

			String[] words = name.split(" ");
			name = "";
			for (String word : words) {

				String firstCharacter = word.substring(0, 1).toUpperCase();
				String leftCharacter = word.substring(1).toLowerCase();
				word = firstCharacter + leftCharacter;
				name += word + " ";
			}
			return name;
		}
	}
}
