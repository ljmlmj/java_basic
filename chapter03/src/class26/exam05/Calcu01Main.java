package class26.exam05;

public class Calcu01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 10;
		int y = 20;
		double x1 = 10.5;
		double y1 = 20.0;
		
		// 계산기 객체 생성
		Calcu01 calcu01 = new Calcu01();
		
		// 정수 합산
		System.out.printf("정수 %d와 %d의 합산 결과는 %d 입니다. \n", x, y, calcu01.sum(x, y));
		// 실수 합산
		System.out.printf("정수 %.1f와 %.1f 합산 결과는 %.2f 입니다. \n", x1, y1, calcu01.sum(x1, y1));

	}

}
