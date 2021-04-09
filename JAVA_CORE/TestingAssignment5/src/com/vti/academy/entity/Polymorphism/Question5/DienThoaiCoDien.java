package com.vti.academy.entity.Polymorphism.Question5;

public abstract class DienThoaiCoDien implements IVuKhi {
	@Override
	public void tanCong() {
		System.out.println("Tấn công kẻ xấu");
	}

	public void ngheDaiRadio() {
		System.out.println("Nghe đài radio");
	}
}
