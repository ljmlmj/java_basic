package homework;

public class IndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String subject = "Hello World";
		
		int location = subject.indexOf("llo");
		System.out.println("subject 문자열 : " + subject);
		System.out.println("r 위치 : " + subject.indexOf("r"));
		System.out.println("Hello 시작 위치 : "+ subject.indexOf("Hello"));
		System.out.println("llo 시작 위치 : " + location);
		System.out.println("World 시작 위치 : " + subject.indexOf("World"));

		System.out.println("====================");
		System.out.println("처음부터 5번째까지 string : " + subject.substring(0, 5));
		System.out.println("6번째부터 끝까지 string : " + subject.substring(6));
		String subString = subject.substring(location, 9);
		System.out.println("llo부터 9번째 위치까지의 substring : " + subString);
	}

}
