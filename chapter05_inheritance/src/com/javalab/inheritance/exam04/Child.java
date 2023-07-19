package com.javalab.inheritance.exam04;

/**
 * 오버라이딩 예제
 * 자식 클래스
 */
public class Child extends Parent{
	
	int x = 200;
	
	// 메소드 오버라이딩 (부모의 메소드를 다시 정의함)
	@Override	// 어노테이션 (없어도됨. 메소드에 대한 정보를 담고있다 meta데이터라고도 함)
	void display2() {
		System.out.println("Child display2()");
	}
	
	// 자식이 새롭게 추가한 메소드
	void display3() {
		System.out.println("Child display3()");
	}

}
