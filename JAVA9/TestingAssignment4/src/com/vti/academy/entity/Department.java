package com.vti.academy.entity;

public class Department {
//	Question 1:	Tạo constructor cho department: 
//	a) không có parameters
//	b) Có 1 parameter là nameDepartment và default id của 
//	Department = 0
//	Khởi tạo 1 Object với mỗi constructor ở trên
	private int id;
	private String name;

	public Department() {
	}

	 public Department(String name) {
		this.id = 0;
		this.name = name;
	}
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
}
