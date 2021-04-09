package com.vti.academy.entity.Collection;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private LocalDate birthday;
	private int score;
	private static int count = 0;

	public Student(String name) {
		this.id = ++count;
		this.name = name;
	}

	public Student(String name, LocalDate birthday, int score) {
		this.id = ++count;
		this.name = name;
		this.birthday = birthday;
		this.score = score;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student student) {
		if (name.compareTo(student.name) > 0) {
			return 1;
		}
		if (name.compareTo(student.name) < 0) {
			return -1;
		}
		return 0;
	}
}
