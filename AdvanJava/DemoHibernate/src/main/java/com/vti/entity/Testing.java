package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Testing", catalog = "TestingSystem")
public class Testing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	// auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	public Testing() {

	}
}
