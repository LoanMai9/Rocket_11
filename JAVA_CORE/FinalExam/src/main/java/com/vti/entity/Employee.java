package com.vti.entity;

public class Employee extends User {
	private int projectId;
	private String proSkill;

	public Employee() {
		super();

	}
	

	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}


	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Id dự án đang tham gia: "+ projectId);
		System.out.println("Ky nang chuyen mon: " + proSkill);
	}
	
}
