package com.javalab.api.pkg05;

public class StringBuilderExample {

	public static void main(String[] args) {
		
		// StringBuilder
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" World");	// 내부적으로 문자를 이어붙이면 한 객체로 버퍼를 줄 수 있다.
		sb.append(" Ha Ha");
		System.out.println(sb);	// prints "Hello World Ha Ha"
		System.out.println();
		
		// String 차이점
		String data = "ABC";
		data += "def";
		System.out.println(data);	// ABCdef
	}

}
