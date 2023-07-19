package sec04;

import java.util.Scanner;

public class CompareTwoNumber {

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
		scanner.close();
	}
}
