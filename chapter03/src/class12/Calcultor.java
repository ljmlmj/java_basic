package class12;

/**
 * 가변길이 메소드 연습 라이브러리 클래스/도메인 클래스/vo클래스 
 */

public class Calcultor {
	int sum(int ...values) {
		int sum = 0;
		
		// values는 배열 타입의 변수처럼 사용
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		
		// 합산 결과를 리턴
		return sum;
	}
	
	
}
