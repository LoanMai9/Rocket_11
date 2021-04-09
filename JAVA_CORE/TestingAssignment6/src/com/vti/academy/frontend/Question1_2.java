package com.vti.academy.frontend;

public class Question1_2 {
	public static void main(String[] args) {
		try {
			float result = divide(7,0);
			System.out.println(result);
		} catch(ArithmeticException e) {
			System.out.println("Cannot divide 0 ");
		}finally {
			System.out.println("Divide completed!");
			
		}
	}

	private static float divide(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
}
