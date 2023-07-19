package sec04;

import java.io.IOException;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

public class Read03Continue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		int keyCode;
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode : " + keyCode);
			if (keyCode == 113) {	// q - 113이면
				break;				// keyCode가 113과 동일할 경우 실행
			}
		}
		*/
		
		int keyCode;
		char c;
		while(true) { // 계속해서 키를 입력받는다.
			System.out.println("==================");
			System.out.println("영어 알파벳과 숫자를 입력하세요.");
			
			// System.in.read() 반환값이 int type
			keyCode = System.in.read(); // 실제로 입력된 key
			c = (char)keyCode;			// 강제 형변환(문자로 변환)
			System.in.read();
			System.in.read();
			if (c >= '0' && c <='9') {
				System.out.printf("key -%c 매핑 문자 %d 입니다. \n", c, keyCode);
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				System.out.printf("key- %c 매핑문자 %d 입니다. \n", c, keyCode);
			} 
		}
	}

}
