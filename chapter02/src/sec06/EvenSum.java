package sec06;

public class EvenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;

		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0 || i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1~10까지 2의배수와 3의배수의 합 : " + sum);
	}

}
