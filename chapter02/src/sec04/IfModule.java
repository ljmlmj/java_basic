package sec04;

import java.util.Scanner;

public class IfModule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("a 숫자 입력 : ");
		int a = scanner.nextInt();
		System.out.println("b 숫자 입력 : ");
		int b = scanner.nextInt();
		System.out.println("--------------------------------");
		System.out.println("결과");
		
		if (a > b) {
			System.out.println("a 가 더 큰 숫자 : " + a);
		} else if (a < b) {
			System.out.println("b 가 더 큰 숫자 : " + b);
		} else {
			System.out.println("a, b 둘 다 같은 숫자 : " + a + " " + b);
		}
		compareTwoNumber(a, b);
		scanner.close();
		
	}
	
	/**
	 * 두 수를 비교해주는 함수
	 * @param a
	 * @param b
	 */
	
	private static void compareTwoNumber(int a, int b) {
		if (a > b ) {
			System.out.println("첫 번째 숫자가 큽니다.");
		} else if (a < b) {
			System.out.println("두 번째 숫자가 큽니다.");
		} else {
			System.out.println("두 수가 같습니다.");
		}
	}
}
