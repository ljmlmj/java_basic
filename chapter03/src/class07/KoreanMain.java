package class07;

// Alt + Shift + R : 변수명 일괄 변경

public class KoreanMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Korean korean1 = new Korean("대한민국", "홍길동", "123456-7892837");
		Korean korean2 = new Korean("대한민국", "김철수", "951206-4687248");
		Korean korean3 = new Korean("김길동", "123456-7892837");
		
		System.out.println("국적 : " + korean1.nation);
		System.out.println("이름 : " + korean1.name);
		System.out.println("주민번호 : " + korean1.ssn);
		System.out.println();
		System.out.println("국적 : " + korean2.nation);
		System.out.println("이름 : " + korean2.name);
		System.out.println("주민번호 : " + korean2.ssn);
		System.out.println();	
		System.out.println("이름 : " + korean3.name);
		System.out.println("주민번호 : " + korean3.ssn);
		
	}

}
