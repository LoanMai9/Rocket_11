package com.vti.academy.entity.Polymorphism.Question3;

public class HinhVuong extends HinhChuNhat {
	public float tinhChuVi(float a) {
		return super.tinhChuVi(a, a);
	}

	public float tinhDienTich(float a) {
		return super.tinhDienTich(a, a);
	}
}
