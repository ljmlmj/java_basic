package sec03;

public class SubStringExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6);	// 0부터 5까지
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);	// 7부터 끝까지
		System.out.println(secondNum);
	}

}
