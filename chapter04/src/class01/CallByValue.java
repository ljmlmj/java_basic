package class01;

/**
 * 메소드간 파라미터 전달
 * - 콜바이 밸류(Call by Value) : 값 전달(복사)
 */

public class CallByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 5;
		int num2 = 10;
		
		int sum = addNumbers(num1, num2);	// 다른 메소드 호출
		
		System.out.println("정수 " + num1 + " 더하기 " + num2 + "은 " + sum);
		
	}
	
	// 덧셈 메소드
	private static int addNumbers(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}
	
	

}
