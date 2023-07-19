package sec06;

import java.util.Scanner;

public class LoginCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String id;
		String pw;
		
		while (true) {
			System.out.println("id를 입력하세요 : ");
			id = scanner.nextLine();
			if (id.equals("java")) {
				break;
			}
		}
		while (true) {
			System.out.println("비밀번호를 입력하세요 : ");
			pw = scanner.nextLine();
			if(pw.equals("1234")) {
				System.out.println("java님 환영합니다.");
				break;
			} else {
				System.out.println("비밀번호가 올바르지 않습니다.");
			}	
		}
		scanner.close();
	}
}
