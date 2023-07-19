package class21;

public class Singletone {
	// private 접근 권한을 갖는 정적 필드 선언과 초기화
	private static Singletone singletone = new Singletone();

	// private 접근 권한을 갖는 생성자 선언
	private Singletone() {
	}

	public static Singletone getInstance() {
		return singletone;
	}
}
