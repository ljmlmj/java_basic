package class13;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Car 객체 생성
		Car myCar = new Car();
		
		// 주유 메소드 setGas() 호출
		myCar.setGas(10); // 기본 생성자 호출
		
		// 기름이 있을 경우 출발
		// isLeftGas() 메소드를 호출해서 받은 리턴값이 true일 경우 if 블록 실행
		if (myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			
			// 운행 run() 메소드 호출
			myCar.run();
		}
		System.out.println("가스를 주입하세요.");
	}
}
