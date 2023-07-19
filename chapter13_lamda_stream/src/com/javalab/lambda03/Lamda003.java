package com.javalab.lambda03;

/**
 * 함수형 인터페이스(메소드가 하나인 인터페이스)
 * 	- 람다식을 만들어서 저장할 인터페이스
 */
@FunctionalInterface
interface MyFunctionalInterface {
	public void run();	// 유일한 추상 메소드
}

/**
 * 람다식 테스트 클래스
 * 	- 매개 변수가 없고 return문이 없는 람다 함수
 */
public class Lamda003 {

	public static void main(String[] args) {

		MyFunctionalInterface fi;	// 함수형 인터페이스 타입 참조 변수
		
		/*
		 * [1] 매개 변수가 없으면 빈 괄호() 사용 가능
		 * 	- 구현 내용이 여러 문장이면 중괄호{}로 감싸야 한다.
		 */
		fi = () -> {	// 익명 구현 객체 생성
			String str = "method call1";
			System.out.println(str);
		};
		fi.run();
		
		// [2] 구현(실행) 내용이 한 줄이면 중괄호{}를 써도 되고, 생략도 가능함 (생략 시 세미콜론도 생략 가능)
		fi = () -> {System.out.println("method call2");};
		fi.run();
		
		// [3] 구현(실행) 내용이 한 줄이면 중괄호 {} 생략 가능
		fi = () -> System.out.println("method call3");
		fi.run();
		
		// 람다식 없이 익명객체 run() 메소드 호출
		fi = new MyFunctionalInterface() {
			public void run() {
				System.out.println("method call4");
			}
		};
		fi.run();
			
		
	}

}
