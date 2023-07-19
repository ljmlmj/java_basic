package com.javalab.exception.pkg01;

/**
 * 실행 예외 (Runtime Exception) 테스트 클래스
 * 	- ArrayIndexOutOfBoundException : 존재하지 않는 배열 인덱스 참조
 */
public class ArrayIndexOutOfExample {

	public static void main(String[] args) {
		
		String[] arrStr = new String[2];
		arrStr[0] = "hi java";
		arrStr[1] = "hi javascript";
		
		//System.out.println(arrStr[3]);	// ArrayIndexOutOfExample 예외 발생
		
		// 교수 객체 저장용 배열 선언
		Professor[] profs = new Professor[3];
		profs[0] = new Professor(50);
		profs[1] = new Professor(55);
		profs[2] = null;				// NullPointerExample 예외 발생
		
		// 배열의 크기를 +1 : ArrayIndexOutOfBoundException
		for (int i = 0; i < profs.length+1; i++) {	// ArrayIndexOutOfExample 예외 발생
			System.out.println(profs[i].age);
		}
	}
}

// 교수 클래스
class Professor {
	// 필드
	public int age = 10;
	// 기본 생성자
	Professor () {
	}
	Professor (int age) {
		this.age = age;
	}
}
