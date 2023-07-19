package class01;

/**
 * 메소드간 파라미터 전달(배열, 객체와 같은 여러 개 값을 담는 객체의 주소 값 전달)
 * - 콜바이 레퍼런스(Call by reference) : 참조 주소값 복사
 */

public class CallByReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {1, 2, 3, 4, 5};	// int 자료형 변수 5개 선언해서 1, 2, 3, 4, 5 저장
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		
		printArray(numbers);				// 배열 출력 메소드 호출
		printArray(a,b,c,d,e);
	
	}
	
	private static void printArray(int a, int b, int c, int d, int e) {	
		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " ");
	}

	private static void printArray(int[] numbers) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	

}
