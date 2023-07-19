package sec07;

public class Array14StringPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] member = {"최진형", "이성준", "최기선"};
		
		// 일반 for문
		for (int i = 0; i < member.length; i++) {
			System.out.println(member[i] + "님이 상담을 받았습니다.");
		}
		
		System.out.println();
		
		// 향상된 for문
		for (String name : member) {
			System.out.println(name + "님이 상담을 받았습니다.");			
		}
	}
}
