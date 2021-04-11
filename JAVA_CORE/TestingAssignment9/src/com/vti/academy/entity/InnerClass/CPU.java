package com.vti.academy.entity.InnerClass;

public class CPU {
	private int price;
	
	public CPU(int price) {
		this.price = price;
	}
	

	public int getPrice() {
		return price;
	}


	public class Processor {
		private int coreAmount;
		private String menufacturer;
		
		public Processor(int coreAmount, String menufacturer) {
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}
		

		public int getCoreAmount() {
			return coreAmount;
		}


		public String getMenufacturer() {
			return menufacturer;
		}


		public float getCache() {
			return (float) 4.3;
		}
	}
	public class Ram{
		private int memory;
		private String menufacturer;
		
		
		public Ram(int memory, String menufacturer) {
			this.memory = memory;
			this.menufacturer = menufacturer;
		}
		public int getMemory() {
			return memory;
		}
		public String getMenufacturer() {
			return menufacturer;
		}
		public float getClockSpeed() {
			return (float) 5.5;
		}
		
		
	}
}
