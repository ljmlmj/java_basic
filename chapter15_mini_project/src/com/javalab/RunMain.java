package com.javalab;

import java.util.Scanner;

/**
 * 콘솔 메뉴
 */
public class RunMain {

	public static void main(String[] args) {
		
		// 키보드에서 입력을 받아들이는 객체
		Scanner in = new Scanner(System.in);
		int option;
		while(true) {
			System.out.println("번호를 입력하세요. 1. 덧셈     2. 뺄셈     3. 나눗셈     4. 곱셈");
			option = Integer.parseInt(in.next());	// 문자열 -> int 변환
			
			if (option == 1) {
				System.out.println("1. 덧셈");
			} else if (option == 2) {
				System.out.println("2. 뺄셈");
			} else if (option == 3) {
				System.out.println("3. 나눗셈");
			} else if (option == 4) {
				System.out.println("4. 곱셈");
			} else {	// 1,2,3,4 이외의 숫자가 올 경우
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
			// 자원 반납
			
		}
		in.close();
		
	}
	
	private static void askForNumbers() {
		System.out.println("두 개의 숫자를 입력하세요.");
		System.out.println();
	}

}
