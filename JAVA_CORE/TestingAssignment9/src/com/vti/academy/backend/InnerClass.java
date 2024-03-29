package com.vti.academy.backend;

import com.vti.academy.entity.InnerClass.CPU;
import com.vti.academy.entity.InnerClass.Car;

public class InnerClass {

	public void question1() {
//		Tạo 2 inner class Processor, Ram
//		Với Processor có các property: coreAmount, menufacturer và 
//		method getCache() và return ra 4.3
//		Với Ram có các property: memory, menufacturer và method 
//		getClockSpeed() và return ra 5.52
//		Sau đó khởi tạo object CPU và in ra cache của Processor và 
//		clockSpeed của Ram

		CPU cpu = new CPU(100);
		CPU.Ram ram = cpu.new Ram(8, "Dell");
		CPU.Processor processor = cpu.new Processor(4, "HP");
		System.out.println(ram.getClockSpeed());
		System.out.println(processor.getCache());
	}

	public void question2() {
		
//		Tạo Car có property: name, type
//		Tạo inner class Engine có property engineType và tạo getter, setter cho 
//		property engineType
//		Khởi tạo object Car có name = Mazda, type = 8WD, có loại động cơ là 
//		"Crysler".
//		Sau đó in ra thông tin của động cơ
		Car car = new Car("Mazda", "8WD");
		Car.Engine engine = car.new Engine();
		engine.setEngineType("Crysler");
		car.setEngine(engine);
		car.printInfor();
	}
}
