package com.vti.academy.entity;

import java.time.LocalDate;
import java.util.Arrays;


public class Group {
	private int id;
	private String groupName;
	private Account creator;
	private Account[] accounts;
	private LocalDate createDate;

	public Group() {
		
	}
	public Group( String groupName, Account creator, Account[] accounts, LocalDate createDate) {
		this.groupName = groupName;
		this.creator= creator;
		this.accounts= accounts;
		this.createDate = createDate;
	}
	public Group(int id, String groupName, Account creator, String[] usernames, LocalDate createDate) {
		this.id = id;
		this.groupName= groupName;
		this.creator = creator;

		// accounts
//		Account[] accounts = new Account[usernames.length];
//		for (int i = 0; i < usernames.length; i++) {
//			accounts[i] = new Account(usernames[i]);
//		}
		this.createDate = createDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", creator=" + creator + ", accounts="
				+ Arrays.toString(accounts) + ", createDate=" + createDate + "]";
	}
	
}

