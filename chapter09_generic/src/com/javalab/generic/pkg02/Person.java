package com.javalab.generic.pkg02;

/** 
 * @param <T> 타입 파라미터 : 객체 생성 시 전달됨
 *	- 전달된 타입(클래스)으로 name 필드의 타입이 정해짐
 */
public class Person<T> {
	private T name;
	private int age;

	public Person() {
	}

	public Person (T name, int age) {
		this.name = name;
		this.age = age;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

