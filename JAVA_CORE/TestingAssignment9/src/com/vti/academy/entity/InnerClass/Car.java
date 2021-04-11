package com.vti.academy.entity.InnerClass;

public class Car {
	private String name;
	private String type;
	private Engine engine;
	public Car(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public class Engine{
		private String engineType;

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

		@Override
		public String toString() {
			return engineType;
		}
	}
	public void printInfor() {
		System.out.println("Car name: "+ name);
		System.out.println("Car type: "+ type);
		System.out.println("Car engine: "+ engine);
	}
}
