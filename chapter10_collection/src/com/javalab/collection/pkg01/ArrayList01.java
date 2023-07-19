package com.javalab.collection.pkg01;

import java.util.ArrayList;

public class ArrayList01 {

	public static void main(String[] args) {
		// Arraylist 생성
		ArrayList<String> fruits = new ArrayList<>();	// 10칸짜리 String 담을 수 있음
		
		// 값 저장
		fruits.add("apple");	// "apple" String type
		fruits.add("banana");
		fruits.add("orange");
		
		// 크기 조회
		int size = fruits.size();
		System.out.println("ArrayList 사이즈 : " + size);
		
		// 인덱스를 이용한 값 조회
		String fruit = fruits.get(1);
		System.out.println("인덱스 1 : " + fruit);
		
		// 반복(iterate) for-each loop
		System.out.println("요소 조회 : ");
		for (String f : fruits) {
			System.out.println(f);
		}
		
		// 바나나 삭제
		fruits.remove("banana");
		System.out.println("Elements of the ArrayList aftrer removal : ");
		for (String f : fruits) {
			System.out.println(f);
		}
	}
}
