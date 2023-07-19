package com.javalab;

import java.util.Scanner;

/**
 * 콘솔 계산기
 */
public class RunMain3 {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int option;
		int number1, number2; // 키보드에서 받아들일 두 숫자 저장용 변수
		
		while(true) {
			System.out.println("Enter your choice 1. 덧셈  2. 뺄셈  3. 나눗셈  4. 곱셈");
			option = Integer.parseInt(in.next());
			
			
			switch (option) {
			case 1:
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double sum = number1 + number2;
				System.out.println("덧셈 결과 : " + sum); 
			case 2:
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double minus = number1 - number2;
				System.out.println("뺄셈 결과 : " + minus);
			case 3:
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double divide = number1 / number2;
				System.out.println("나눗셈 결과 : " + divide);
			case 4:
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double multiple = number1 * number2;
				System.out.println("곱셈 결과 : " + multiple);

			default:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
			/*
			if (option == 1) {
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double sum = number1 + number2;
				System.out.println("덧셈 결과 : " + sum); 
			} else if (option == 2) {
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double minus = number1 - number2;
				System.out.println("뺄셈 결과 : " + minus);
			} else if (option == 3) {
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double divide = number1 / number2;
				System.out.println("나눗셈 결과 : " + divide);
				
			} else if (option == 4) {
				askFornumbers();
				number1 = Integer.parseInt(in.next());
				number2 = Integer.parseInt(in.next());
				double multiple = number1 * number2;
				System.out.println("곱셈 결과 : " + multiple);
			} else {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		*/
			in.close();
		}
		
		
	
	}
	
	private static void askFornumbers() {
		System.out.println("두 개의 숫자를 입력하세요.");
		System.out.println();
	}

}
