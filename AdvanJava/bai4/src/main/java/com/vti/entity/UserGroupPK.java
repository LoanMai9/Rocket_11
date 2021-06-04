package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGroupPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "group_id", nullable = false)
	private short groupId;
	
	@Column(name = "user_id", nullable = false)
	private short userId;
	
	
	public UserGroupPK() {
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

}
