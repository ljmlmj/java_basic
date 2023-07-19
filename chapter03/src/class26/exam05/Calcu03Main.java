package class26.exam05;

public class Calcu03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 계산기 클래스 객체 생성
		Calcu03 cal = new Calcu03();
		
		System.out.println("======== 정수 평균 구하는 메소드 호출 ========");
		cal.execute(20, 30);
		
		System.out.println("======== 실수 평균 구하는 메소드 호출 ========");
		cal.execute(20.5, 30.5);
	}

}
