package com.javalab.inheritance.exam03.pkg01;

public class SmartPhone extends Phone {
	
	public String frequency;

	public SmartPhone() {
		super();
	}
	
	public SmartPhone(String model, String color) {
		super(model, color);
		
	}

	public SmartPhone(String model, String color, String frequency) {
		super(model, color);
		this.frequency = frequency;
	}
	
	public void showSmartPhoneInfo() {
		this.showPhoneInfo();
		System.out.println("사용 빈도 : " + this.frequency);
	}
}
