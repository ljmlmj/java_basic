package homework;

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "test"; // 리터럴 사용
		String str2 = new String("test"); // new 연산자 사용
		String str3 = "test";
		
		System.out.println("str => " + str);
		System.out.println("str2 => " + str2);
		
		if(str == str2) {
			System.out.println("str 와 str2 는 같습니다.");
		}else{
			System.out.println("str 와 str2 는 다릅니다."); // 출력
		}
		
		if(str == str3) {
			System.out.println("str 와 str3 는 같습니다."); // 출력
		}else {
			System.out.println("str 와 str3 는 다릅니다.");
		}
		
		if(str.equals(str3)) {
			System.out.println("equal 함수를 이용한 str 와 str3 는 같습니다."); //출력
		}else {
			System.out.println("equal 함수를 이용한 str 와 str3 는 다릅니다.");
		}
	}
}
