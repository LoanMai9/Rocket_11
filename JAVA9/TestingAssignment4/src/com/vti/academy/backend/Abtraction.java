package com.vti.academy.backend;

import com.vti.academy.entity.Abstraction.Question1.Phone;
import com.vti.academy.entity.Abstraction.Question1.VietnamesePhone;
import com.vti.academy.entity.Abstraction.Question2_3.Employee;
import com.vti.academy.entity.Abstraction.Question2_3.Manager;
import com.vti.academy.entity.Abstraction.Question2_3.Waiter;

public class Abtraction {
	public void Question1() {
		Phone phone = new VietnamesePhone();
		phone.insertContract("Bella", "0123456789");
		phone.insertContract("Edward", "012567382");
		phone.updateContract("Bella", "0123668899");
		phone.removeContract("Edward");
		phone.searchContact("Edward");
	}
	
	public void Question2_3() {
		Employee em = new Employee("Bella", 9.0);
		em.displayInfor();
		
		Manager ma = new Manager("Edward", 8.5);
		ma.displayInfor();
		
		Waiter wa = new Waiter("Cullen",8.0);
		wa.displayInfor();
	}
}
