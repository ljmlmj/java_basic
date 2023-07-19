package sec07;

/**
 * 세 과목의 평균 구하기
 */
public class Array010ld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 80;
		int b = 75;
		int c = 90;
		int sum = 0;
		
		sum = a + b + c;
		double avg = sum / 3.0;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("총점 : " + sum);
		System.out.println("1. 평균 : " + avg);
		System.out.printf("2. 평균 : %.2f", avg);
		System.out.println();
		System.out.println("3. 평균 : " + Math.round(avg * 100)/100.0);
		System.out.println(String.format("4. 평균 : %.2f", avg));
	}
}
