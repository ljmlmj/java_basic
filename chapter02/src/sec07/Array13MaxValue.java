package sec07;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

/**
 * - 출력 결과 : 제일 큰 수는 : 50
 */
public class Array13MaxValue {
	public static void main(String[] args) {
		
		// 1. 배열 사용전
		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		int e = 50;
		
		int maxNum = 0;
		
		if (a>maxNum)
			maxNum = a;
		if (b>maxNum)
			maxNum = b;
		if (c>maxNum)
			maxNum = c;
		if (d>maxNum)
			maxNum = d;
		if (e>maxNum) 
			maxNum = e;
		
		System.out.println("가장 큰 수 : " + maxNum);
		
		// 배열 사용 1 (향상된 for문)		
		int intArr[] = {10, 20, 30, 40, 50};
		
		maxNum = 0;
		for (int ar : intArr) {
			if (ar > maxNum ) {
				maxNum = ar;
			}
		}
		System.out.println("가장 큰 수 : " + maxNum);
		
		// 배열 사용 2 (일반 for문)
		maxNum = 0;
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] > maxNum) {
				maxNum = intArr[i];
			}
		}
		System.out.println("가장 큰 수 : " + maxNum);
	}
}
