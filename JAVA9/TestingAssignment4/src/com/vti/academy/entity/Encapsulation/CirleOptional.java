package com.vti.academy.entity.Encapsulation;

public class CirleOptional {
	private double radius;
	private String color;
	
	public void CirleOptional() {
		
	}
	public void CirleOptional(double radius) {
			this.radius =radius;
		}
	public void CirleOptional(double radius, String color) {
		this.radius =radius;
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
//	public double getArea() {
//		return area; 
//	}
	@Override
	public String toString() {
		return "CirleOptional [radius=" + radius + ", color=" + color + "]";
	}
	
}
