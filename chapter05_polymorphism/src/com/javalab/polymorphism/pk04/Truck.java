package com.javalab.polymorphism.pk04;

public class Truck extends Vehicle {

	// 메소드 재정의 (오버라이딩)
	@Override
	public void run() {
		System.out.println("트럭이 물건을 싣고 달립니다.");
		
	}
}
