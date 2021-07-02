package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name = "User_Group", catalog = "TestingSystem")
public class UserGroup implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserGroupPK id;
	
	@Column(name = "join_time")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinTime;

	

	public UserGroupPK getId() {
		return id;
	}



	public void setId(UserGroupPK id) {
		this.id = id;
	}



	public Date getJoinTime() {
		return joinTime;
	}



	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}



	@Override
	public String toString() {
		return "UserGroup [id=" + id.getGroupId() +  ", userId=" + id.getUserId() +", joinTime=" + joinTime + "]";
	}

	
	
}
