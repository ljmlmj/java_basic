package sec07;

import java.util.Stack;

import sun.font.StrikeCache;

public class Array04Init {
	public static void main(String[] args) {
		// 각 type(자료형) 별로 배열 선언
		int[] intArr = new int[3];
		double[] dblArr = new double[3];
		float[] floatArr = new float[3];
		boolean[] boolArr = new boolean[3];
		String[] strArr = new String[3];
		// 자동으로 초기화된 값 확인하기
		System.out.println("intArr[1] : " + intArr[1]);
		System.out.println("dblArr[1] : " + dblArr[1]);
		System.out.println("floatArr[1] : " + floatArr[1]);
		System.out.println("boolArr[1] : " + boolArr[1]);
		System.out.println("strArr[1] : " + strArr[1]);
	}
}
