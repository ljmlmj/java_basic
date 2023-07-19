package com.javalab.inheritance.exam03.pkg01;

public class SmartPhoneMain {

	public static void main(String[] args) {
		// 1. SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone();
		myPhone.model = "갤럭시노트10";
		myPhone.color = "화이트";
		myPhone.frequency = "6G";
	
		// myPhone 정보 조회
		myPhone.showSmartPhoneInfo();
		System.out.println();
		
		// 2. 또 다른 SmartPhone 객체 생성
		SmartPhone yourPhone = new SmartPhone("iPhone", "빨간색", "4G");
		
		// yourPhone 정보 조회
		yourPhone.showSmartPhoneInfo();
	}
}
