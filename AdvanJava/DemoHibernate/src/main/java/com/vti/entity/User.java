package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "User", catalog = "TestingSystem")

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 800, nullable = false)
	private String password;

	@Column(name = "firstName", length = 50, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 50, nullable = false)
	private String lastName;

	@Column(name = "date_Of_Birth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone", length = 15, nullable = false, unique = true)
	private String phone;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@OneToOne(mappedBy = "author")
	private Group group;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private Set<TestingCategory> testingCategory;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private Set<QuestionCategory> categories;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private Set<Image> images;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private Set<Question> questions;

	public User() {

	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<QuestionCategory> getCategories() {
		return categories;
	}

	public void setCategories(Set<QuestionCategory> categories) {
		this.categories = categories;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
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


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<TestingCategory> getTestingCategory() {
		return testingCategory;
	}

	public void setTestingCategory(Set<TestingCategory> testingCategory) {
		this.testingCategory = testingCategory;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + "]";
	}	
	
}
