package com.vti.academy.entity;

public class Student {
	private int id;
	public static int counter=0;
	private String name; 
	public Student() {
		counter++;
		this.id = counter;
	}
	/**
	 * @deprecated replaced by {@link #getIdV2(Student)}}
	 */
	@Deprecated
	public int getId() {
		return id;
	}
	public String getIdV2() {
		return "MSV: " +id ;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
