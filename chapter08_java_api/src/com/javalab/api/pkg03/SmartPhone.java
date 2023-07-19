package com.javalab.api.pkg03;

public class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	// 객체의 내부 정보를 보여주는 메소드
	// 부모(Object)가 갖고 있는 메소드 재정의함
	
	@Override
	public String toString() {
		return company + ", " + os;
	}
}
