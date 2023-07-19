package com.javalab.polymorphism.pk04;

// 택시 클래스
public class Taxi extends Vehicle {
	
	// Vehicle 객체의 run() 메소드 재정의 (오버라이딩)
	@Override
	public void run() {
		System.out.println("택시가 손님을 싣고 목적지까지 달립니다.");
	}
}
