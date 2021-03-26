package com.vti.academy.entity.Encapsulation;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float acedamicScore;

	public Student() {

	}

	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.acedamicScore = 0;
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getAcedamicScore() {
		return acedamicScore;
	}

	public void setAcedamicScore(float acedamicScore) {
		this.acedamicScore = acedamicScore;
	}

	public void plusAcedamicScore(float acedamicScore) {
		this.acedamicScore += acedamicScore;
	}

	@Override
	public String toString() {
		String grade;
		if (acedamicScore < 4.0) {
			grade = "Yếu";
		} else if (acedamicScore < 6.0) {
			grade = "Trung bình";
		} else if (acedamicScore < 8.0) {
			grade = "Khá";
		} else {
			grade = "Giỏi";
		}
		return "Student [id= " + id + ", name= " + name + ", hometown= " + hometown + ", acedamicScore= " 
				+ acedamicScore + ", Xếp loại: " + grade + "]";
	}

}
