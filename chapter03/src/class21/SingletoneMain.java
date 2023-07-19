package class21;

public class SingletoneMain {

	public static void main(String[] args) {

		/*
		Singletone obj1 = new Singletone(); // 컴파일 에러
		Singletone obj2 = new Singletone(); // 컴파일 에러
		 */
		
		// 정적 메소드를 호출해서 싱글톤 객체 얻음
		Singletone obj1 = Singletone.getInstance();
		Singletone obj2 = Singletone.getInstance();
		
		System.out.println("obj1 : " + obj1);
		System.out.println("obj2 : " + obj2);
		System.out.println();
		
		// 동일한 객체를 참조하는지 확인
		if (obj1 == obj2) {
			System.out.println("같은 Singletone 객체입니다.");
		} else {
			System.out.println("다른 Singletone 객체입니다.");
		}
	}

}
