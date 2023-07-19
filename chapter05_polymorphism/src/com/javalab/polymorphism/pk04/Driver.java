package com.javalab.polymorphism.pk04;

/*
 * 운전을 해주는 클래스
 */

public class Driver {
	
	// 운전 메소드 선언 (파라미터를 부모 타입으로 받고 있음. 자동 형 변환)
	public void drive (Vehicle vehicle) {
		vehicle.run();
	}

}
