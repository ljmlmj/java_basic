package com.javalab.inheritance.exam03.pkg01;

public class Phone extends Object {	// Object는 자동으로 상속해준다.
	// 필드 선언
	public String model;
	public String color;
	
	// 생성자 선언
	public Phone() {
		super(); // 최고 조상 Object 상속
	}
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	public void showPhoneInfo() {
		System.out.println("[휴대폰 정보]");
		System.out.println("모델명 : " + model);
		System.out.println("색상 : " + color);
	}
}
