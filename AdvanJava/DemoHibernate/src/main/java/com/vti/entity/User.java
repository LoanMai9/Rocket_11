package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "User", catalog = "TestingSystem")

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id 
	//auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "username",length = 50, nullable = false, unique = true)
	private String name;
	
	@Column(name = "email",length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password",length = 800, nullable = false)
	private String password;
	
	@Column(name = "firstname",length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "lastname",length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "address",length = 100, nullable = false)
	private String address;
	
	@Column(name = "phone",length = 15, nullable = false)
	private String phone;

	public User() {
	
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + "]";
	}	
	
}
