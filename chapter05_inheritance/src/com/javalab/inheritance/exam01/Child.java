package com.javalab.inheritance.exam01;

public class Child extends Parent{
	
	public String address;
	public String phone;
	
	public Child(){
		super();	// 첫 줄에서 부모 객체 기본 생성자 호출 
		// 생성자의  첫 줄에서 어떠한 형태로라도 super를 호출하지 않으면 컴파일러에서 super();을 자동으로 넣어준다.
	}
	
	public Child(String address) {
		super("김길동", 29);			// 부모 필드 초기화
		this.address = address;		// 자기 필드 초기화
		System.out.println("자식 객체의 생성자1");
	} 
	
	public Child(String address, String phone) {
		this.address = address;
		this.phone = phone;
		System.out.println("자식 객체의 생성자2");
	}
}
