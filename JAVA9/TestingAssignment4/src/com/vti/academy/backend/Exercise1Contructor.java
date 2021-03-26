package com.vti.academy.backend;

import java.time.LocalDate;

import com.vti.academy.entity.Account;
import com.vti.academy.entity.Department;
import com.vti.academy.entity.Position;

public class Exercise1Contructor {

	public void question1() {

		// construct object
		Department department = new Department();
		Department department1 = new Department("Sale");

		// print object
		System.out.println(department);
		System.out.println(department1);
	}
	public void question2() {
		// a
		Account account = new Account();
		System.out.println(account);

		// b
		Account account1 = new Account(1, "abc@gmail.com", "abc", "sauds", "sadsda");
		System.out.println(account1);

		// c
		Position position1 = new Position(1, "Sale");
		Position position2 = new Position(2, "Marketing");
				LocalDate.parse("2020-05-15");
		System.out.println(account1);
	}
}
