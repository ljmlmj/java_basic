package class17;

/**
 * 실행클래스
 */
public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
		
		int radius = 10; // 반지름
		double area = calc.area(radius);
		System.out.printf("원의 반지름이 %d 일 때 원의 넓이는 %.2f 입니다. ", radius, area);
		System.out.println(); 
		
		Calculator calc2 = new Calculator();
		radius = 20;
		area = calc2.area(radius);
		System.out.printf("원의 반지름이 %d 일 때 원의 넓이는 %.2f 입니다. ", radius, area);
	}

}
