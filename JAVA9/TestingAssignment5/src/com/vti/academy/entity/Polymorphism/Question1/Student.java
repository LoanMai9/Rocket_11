package com.vti.academy.entity.Polymorphism.Question1;

public class Student implements IStudent{
	private int id;
	private String name;
	private int group;
	
	
	public Student(int id, String name, int group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}
	
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public int getGroup() {
		return group;
	}


	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh ");
		
	}
	@Override
	public void hocBai() {
		System.out.println(name +" dang học bài ");
	}
	@Override
	public void donVesinh() {
		System.out.println(name +" đang dọn vệ sinh ");
	}
	
	
}
