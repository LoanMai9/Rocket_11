package com.vti.academy.entity.Final;


public class Student {
	public final int id;
	public  String name;
	

	public Student( int id,String name) {
		this.id =id;
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}

	public static void study() {
		System.out.println( "đang học bài. ");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name +"]";
	}

	
}
