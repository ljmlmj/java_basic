package chap01;

public class CharToCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char var1 = 'A';
		char var2 = 'B';
		char var3 = '가';
		char var4 = '각';
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		char ch = 'A';			// char ch = 65;
		int intCode = 'B';
		System.out.printf("%c = %d \n", ch, intCode);
		
		char characteC = 'a';
		int charCode = (int)characteC;
		System.out.printf("%c = %d \n", characteC, charCode);
		
	}

}
