package sec08;

public class String01Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jumin = "901030-2383763";
		
		// [1] charAt
		// 문자열을 반복문을 통해서 한 자씩 추출
		for (int i = 0; i < jumin.length(); i++) {
			System.out.println(jumin.charAt(i));
		}
		
		// [2] substring()함수로 주민번호 앞 뒤를 각각 출력
		String front = jumin.substring(0, 6);
		String back = jumin.substring(7);
		System.out.println("주민번호 앞자리 : " + front);
		System.out.println("주민번호 뒷자리 : " + back);
		
		// [3] 주민번호로 남성입니다. 여성입니다. 구분해서 출력
		
		if (jumin.substring(7,8) == "1") 
			System.out.println("남성입니다");
		else 
			System.out.println("여성입니다.");
		
		// [4] split() 함수
		// [4-1] 주민번호를 '-' 기준으로 split, 여성/남성 입니다
		String[] juminArr = jumin.split("-");
		System.out.println(juminArr[0] + " " + juminArr[1]);
		String gender = juminArr[1].substring(0,1);
		
		if (gender.equals("1"))
			System.out.println("남성입니다.");
		else
			System.out.println("여성입니다.");
		
		// [4-2] 문자열을 ';' 기준으로 split
		String str1 = "홍길동;천안;28;도술;010-2345-6789";
		String[] str2 = str1.split(";");
		for (int i = 0; i < str2.length; i++) {
			System.out.print(str2[i] + "\t");
		}
		System.out.println();
		
		// [4-3] 전화번호를 문자열 자르기 split()
		String str = "010-1234-5678";
		String[] num = str.split("-");
		System.out.println();
		System.out.println(num[0] + num[1] + num[2]);
		
		// [4-4] replace
		System.out.println();
		System.out.println("replace : " + str1.replace("-", ""));
		
		// [5] indexOf("구분자") 구분자의 위치 반환, 주민등록번호 뒷자리
		System.out.println("주민등록번호 뒷자리 위치 : " + jumin.indexOf(back)); 
	}
}
