package sec07;

import java.util.Scanner;

public class Array20LottoRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언 - 6개 공간 담는 배열 선언 (공간확보)
		int[] numArr = new int[6];

		// 세트입력 (Scanner - 2byte)
		Scanner scan = new Scanner(System.in);
		System.out.println("몇 세트의 난수를 발생시키겠습니까?");
		int set = scan.nextInt();

		// while
		while (set > 0) {
			// 난수 발생 for
			for (int i = 0; i < numArr.length; i++) {
				// 난수 1~45
				numArr[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (numArr[j] == numArr[i]) {
						i = i - 1;
						break;
					}
				}
			}
			// 한 세트 출력 (향상된 for문)
			for (int i : numArr) {
				System.out.print(i + "\t");
			}
			System.out.println();
			set = set - 1;
		}
	}
}
