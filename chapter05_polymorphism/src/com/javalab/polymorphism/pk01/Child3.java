package com.javalab.polymorphism.pk01;

public class Child3 extends Parent {

	@Override // 오버라이딩 검사 역할
	public void showPersonality() {
		System.out.println("셋째의 성격은 부모를 닮아서 차분합니다.");
	}
}
