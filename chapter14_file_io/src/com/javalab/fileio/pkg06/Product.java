package com.javalab.fileio.pkg06;

import java.io.Serializable;

/*
 * 직렬화용 Product 클래스
 * 	- 자바에서는 Serializable 인터페이스를 구현한 클래스만 직렬화가 가능
 * 	- 직렬화 대상은 (인스턴스 필드)만으로 제한됨.
 * 	- 이클립스가 자동으로 serialVersionUID를 생성해 줄 수도 있다.
 * 	     개발자가 안 만들면 컴파일러가 컴파일 타임에 만들어서 바이트 코드에 넣어줌.
 */
public class Product implements Serializable {
	// 직렬화 역직렬화 시 같은 클래스 타입이라는 것을 증명해주는 역할
	//private static final long serialVersionUID = -621812868470078544L;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2740136124603264052L;
	private String name;
	private int price;
	
	public Product (String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
