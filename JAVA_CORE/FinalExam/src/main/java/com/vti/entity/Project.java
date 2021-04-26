package com.vti.entity;

public class Project {
	private int projectId;
	private int teamSize;
	private int idManager;
	private int idEmployees;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getIdManager() {
		return idManager;
	}
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
	public int getIdEmployees() {
		return idEmployees;
	}
	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}
	public void getInforpro() {
		System.out.println("Id dự án tham gia: "+ projectId);
		System.out.println("Số người trong dự án: "+ teamSize);
		System.out.println("Id của người quản lý: "+idManager);
		System.out.println("Các thành viên trong team: "+ idEmployees);
	}
	
	
}
