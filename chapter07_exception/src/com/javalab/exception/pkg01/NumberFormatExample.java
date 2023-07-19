package com.javalab.exception.pkg01;

public class NumberFormatExample {

	public static void main(String[] args) {
		
		String strNum = "20o";						// 문자
		int intNum = Integer.parseInt(strNum);		// NumberFormatException 예외 발생 (Integer.parseInt() 수행 불가)
		System.out.println(strNum + " " + intNum);
	}

}
