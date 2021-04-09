package com.vti.academy.entity.Abstraction.Question2;

public class Khoi {
	private String monThi;
	private String ten;
	
	public String getMonThi() {
		if(ten.equals("A")) {
			monThi ="Toán, Lý ,Hóa";
		}else if(ten.equals("B")) {
			monThi =" Toán,Hóa,Sinh";
		} else if(ten.equals("C")) {
			monThi="Văn, Sử, Địa";
		}else {
			monThi ="Môn không xác định";
		}
		return monThi;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}

	
	
}
