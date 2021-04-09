package com.vti.academy.entity.Generic;

public class Staff<T> extends MyMap<T, String>{

	
	

	public Staff(T id, String name) {
		super(id, name);
	}
	public T getId() {
		return getKey();
		
	}
	public String getName() {
		return super.getValue();
		
	}
}
