package com.vti.academy.entity;

public class Position {
	public int id;
	public String name;

	public Position() {
		
	}
	public Position(int id, String name) {
		this.id=id;
		this.name= name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	
}

