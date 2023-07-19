package homework;

public class Contains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "사과는 영어로 apple";
		 
        System.out.println(str.contains("사과"));
        System.out.println(str.contains("는"));
        System.out.println(str.contains("영어로"));
        System.out.println(str.contains("APLLE"));
        System.out.println(str.contains("apple"));
        
        boolean result = str.contains("사과");
		if (result) {
			System.out.println("String에 사과 포함");
		} else {
			System.out.println("String에 사과 미포함");
		}
	}

}
