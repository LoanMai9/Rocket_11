package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Reset_Password_Token", catalog = "TestingSystem")
public class ResetPasswordToken implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "token", length = 36, nullable = false, unique = true)
	private String token;
	
	@Column(name = "user_id", nullable = false)
	private short userId;
	
	@Column(name = "expiryDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	public ResetPasswordToken(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "ResetPasswordToken [id=" + id + ", token=" + token + ", userId=" + userId + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
}
