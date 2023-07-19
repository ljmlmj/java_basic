package class06;

/**
 * 라이브러리 클래스, 도메인 클래스 기본 생성자 생성자 오버로딩
 * - 다양한 형태로 객체를 초기화하는 역할
 */
public class Car {

	// 필드(멤버 변수)
	String model; // 모델명
	String color; // 색상
	int speed; // 속도
	boolean start; // 출발 여부

	// 기본 생성자 : 필드값 초기화
	public Car() {
	}

	// 오버로딩 생성자 #1
	public Car(String mo) {
		model = mo;
	}

	// 오버로딩 생성자 #2
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}

	// 오버로딩 생성자 #3
	public Car(String mo, String co, int sp) {
		model = mo;
		color = co;
		speed = sp;
	}

	// 오버로딩 생성자 #4
	public Car(String mo, String co, int sp, boolean st) {
		model = mo;
		color = co;
		speed = sp;
		start = st;
	}
}
